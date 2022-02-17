package rowan.app.mvc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rowan.app.data.dto.response.LoginResult;
import rowan.app.data.vo.UserAccount;
import rowan.app.mvc.repo.UserRepositoryCustom;
import rowan.app.mvc.repo.impl.UserAccountRepository;
import rowan.app.mvc.service.UserService;
import rowan.app.utils.JwtUtil;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepositoryCustom userRepositoryCustom;
    private final UserAccountRepository userAccountRepository;
    private final JwtUtil jwtUtil;

    @Override
    public LoginResult.Basic login(String id, String password) {

        Optional<UserAccount> isAccount = userAccountRepository.getByUserId(id);

        if(isAccount.isEmpty()){

        }

        UserAccount account = isAccount.get();

        boolean check = account.getPassword().password_match(password);

        if(check){

        }

        return LoginResult.Basic.builder().access(jwtUtil.createAccessToken(account.getUserId())).refresh(jwtUtil.createRefreshToken(account.getUserId())).build();

    }




}
