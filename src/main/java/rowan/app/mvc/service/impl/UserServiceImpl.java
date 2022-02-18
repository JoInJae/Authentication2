package rowan.app.mvc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rowan.app.conf.exception.client.login.InactiveUserException;
import rowan.app.conf.exception.client.login.WrongUserIdException;
import rowan.app.conf.exception.client.login.WrongUserPasswordException;
import rowan.app.data.dto.response.LoginResult;
import rowan.app.data.type.ServiceType;
import rowan.app.data.type.UserLogType;
import rowan.app.data.vo.UserAccount;
import rowan.app.data.vo.UserLog;
import rowan.app.mvc.repo.UserRepositoryCustom;
import rowan.app.mvc.repo.impl.UserAccountRepository;
import rowan.app.mvc.service.UserService;
import rowan.app.utils.JwtUtil;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepositoryCustom userRepositoryCustom;

    private final UserAccountRepository userAccountRepository;

    private final JwtUtil jwtUtil;

    private final EntityManager em;

    @Override
    public LoginResult.Basic login(String id, String password) {

        Optional<UserAccount> isAccount = userAccountRepository.getByUserId(id);

        if(isAccount.isEmpty()) throw new WrongUserIdException(id);

        UserAccount account = isAccount.get();

        boolean check = account.getPassword().password_match(password);

        if(check) throw new WrongUserPasswordException(id, password);

        if(!account.getActive()) throw new InactiveUserException(id);

        return LoginResult.Basic.builder().access(jwtUtil.createAccessToken(account.getUserId())).refresh(jwtUtil.createRefreshToken(account.getUserId())).build();

    }

    @Transactional
    @Override
    public void user_log_put(String id, ServiceType serviceType, UserLogType userLogType, String etc){

        UserLog log = UserLog.builder().userId(id).serviceType(serviceType).logType(userLogType).etc(etc).build();

        em.persist(log);

    }

    @Transactional
    @Override
    public void test() {

        userRepositoryCustom.update_hashed_password();

    }


}
