package rowan.app.mvc.repo;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import rowan.app.data.vo.QUserAccount;

@RequiredArgsConstructor
@Repository
public class UserRepositoryCustom {

    private final JPAQueryFactory query;

    QUserAccount q_user_account = QUserAccount.userAccount;

    public void update_hashed_password(){

        //query.update(q_user_account).set(q_user_account.password.hashedPassword, q_user_account.pw.stringValue().append(q_user_account.salt.stringValue())).execute();

    }

}
