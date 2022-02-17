package rowan.app.conf.key;

import lombok.Setter;
import rowan.app.utils.KmsUtil;
import rowan.app.utils.S3Util;

public class JwtDataKey {

    private static final JwtDataKey jwtDataKey = new JwtDataKey();

    @Setter
    private String secret;

    private JwtDataKey() {
        this.secret = new S3Util().getJwtKey();
    }

    public static JwtDataKey getInstance(){return jwtDataKey;}

    public String getSecret() {return new KmsUtil().decrypt(secret);}

}
