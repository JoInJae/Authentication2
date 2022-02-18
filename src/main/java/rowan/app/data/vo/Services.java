package rowan.app.data.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity@Table(name = "brain_services")
@Getter@NoArgsConstructor
public class Services {

    @Id@Column(name = "service_code", columnDefinition = "CHAR(3)", nullable = false)
    private String code;

    @Column(name = "service_name", columnDefinition = "VARCHAR(20)", nullable = false)
    private String name;

    @Column(name = "service_type", columnDefinition = "VARCHAR(10)", nullable = false)
    private String type;

    @Column(name = "service_server_address", columnDefinition = "VARCHAR(10)", nullable = false)
    private String server;

    @Column(name = "service_etc", columnDefinition = "VARCHAR(100)")
    private String etc;

}
