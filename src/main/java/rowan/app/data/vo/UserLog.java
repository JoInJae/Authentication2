package rowan.app.data.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import rowan.app.data.type.ServiceType;
import rowan.app.data.type.UserLogType;
import rowan.app.data.vo.base.BaseEntity;
import rowan.app.data.vo.embed.Password;
import rowan.app.data.vo.transform.YesOrNoConvert;

import javax.persistence.*;

@Entity@Table(name = "brain_user_log")
@Getter@NoArgsConstructor
@AttributeOverrides(
        @AttributeOverride(name = "idx", column = @Column(name = "user_account_idx", columnDefinition = "BIGINT", nullable = false, updatable = false))
)
public class UserLog extends BaseEntity {

    @Column(name = "user_log_id", columnDefinition = "VARCHAR(50)", nullable = false)
    private String userId;

    @Column(name = "user_log_service", columnDefinition = "VARCHAR(50)", nullable = false)
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    @Column(name = "user_log_type", columnDefinition = "VARCHAR(50)", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserLogType logType;

    @Column(name = "user_log_etc", columnDefinition = "VARCHAR(100)")
    private String etc;

    @Builder
    public UserLog(String userId, ServiceType serviceType, UserLogType logType, String etc) {
        this.userId = userId;
        this.serviceType = serviceType;
        this.logType = logType;
        this.etc = etc;
    }
}
