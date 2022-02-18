package rowan.app.data.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import rowan.app.data.vo.base.BaseEntity;
import rowan.app.data.vo.embed.Password;
import rowan.app.data.vo.transform.PasswordConvert;
import rowan.app.data.vo.transform.YesOrNoConvert;

import javax.persistence.*;

@Entity@Table(name = "brain_user_account")
@Getter@NoArgsConstructor
@AttributeOverrides(
        @AttributeOverride(name = "idx", column = @Column(name = "user_account_idx", columnDefinition = "BIGINT",nullable = false, updatable = false))
)
public class UserAccount extends BaseEntity {

    @Column(name = "user_account_id", columnDefinition = "VARCHAR(50)", nullable = false)
    private String userId;

    @Column(name = "user_account_password")
    private String pw;

    @Column(name = "user_account_salt")
    private String salt;

    @Column(name = "user_account_hashed_password", columnDefinition = "CHAR(76)", nullable = false)
    @Convert(converter = PasswordConvert.class)
    private Password password;

    @Column(name = "user_account_token_push", columnDefinition = "LONGTEXT")
    private String push;

    @Column(name = "user_account_token_refresh", columnDefinition = "LONGTEXT")
    private String refresh;

    @Column(name = "user_account_yn_active", columnDefinition = "ENUM('Y', 'N')", nullable = false)
    @Convert(converter = YesOrNoConvert.class)
    private final Boolean active = false;

}
