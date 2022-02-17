package rowan.app.data.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import rowan.app.data.vo.base.BaseEntity;
import rowan.app.data.vo.embed.Password;
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

    @AttributeOverrides({
            @AttributeOverride(name = "password", column =  @Column(name = "user_account_password", columnDefinition = "CHAR(64)", nullable = false)),
            @AttributeOverride(name = "salt", column =  @Column(name = "user_account_salt", columnDefinition = "CHAR(12)", nullable = false))
    })
    @Embedded
    private Password password;

    @Column(name = "user_account_token_push", columnDefinition = "LONGTEXT")
    private String push;

    @Column(name = "user_account_token_refresh", columnDefinition = "LONGTEXT")
    private String refresh;

    @Column(name = "user_account_yn_active", columnDefinition = "ENUM('Y', 'N')", nullable = false)
    @Convert(converter = YesOrNoConvert.class)
    private final Boolean active = false;

    public boolean isActive(){
        return !active;
    }

}
