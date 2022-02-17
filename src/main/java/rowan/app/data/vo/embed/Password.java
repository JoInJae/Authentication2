package rowan.app.data.vo.embed;

import com.google.common.hash.Hashing;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import javax.persistence.Embeddable;
import java.nio.charset.StandardCharsets;

@NoArgsConstructor
@Embeddable
@Getter
public class Password {

    private String password;
    private String salt;

    public Password(String password) {
        String random = RandomStringUtils.randomAlphanumeric(12);
        this.salt = random;
        this.password = encrypt_password(password, random);
    }

    public boolean password_match(String input){
        return !password.equals(encrypt_password(input, salt));
    }

    private String encrypt_password(String password, String salt){
        return Hashing.sha256().hashString(password+salt, StandardCharsets.UTF_8).toString();
    }

}
