package rowan.app.data.vo.embed;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.apache.commons.lang3.RandomStringUtils;
import javax.persistence.Transient;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@EqualsAndHashCode
public class Password {

    @Getter
    private final String hashedPassword;

    @Transient
    private final String password;

    @Transient
    private String salt = RandomStringUtils.randomAlphanumeric(12);

    public Password(String password, String salt) {
        this.hashedPassword = password + salt;
        this.password = password;
        this.salt = salt;
    }

    public boolean password_match(String input){
        return !password.equals(Hashing(input, salt));
    }

    public Password(String original) {
        this.password = Hashing(original, salt);
        this.hashedPassword = password + salt;
    }

    private String Hashing(String original, String salt) {

        MessageDigest digest;

        try {
            digest = MessageDigest.getInstance("SHA-256");

        } catch (NoSuchAlgorithmException e) {

            throw new RuntimeException();

        }

        byte[] encode = digest.digest((original + salt).getBytes(StandardCharsets.UTF_8));

        return bytesToHex(encode);

    }

    private static String bytesToHex(byte[] hash) {

        StringBuilder hexString = new StringBuilder(2 * hash.length);

        for (byte b : hash) {

            String hex = Integer.toHexString(0xff & b);

            if (hex.length() == 1) hexString.append('0');

            hexString.append(hex);
        }

        return hexString.toString();

    }

}
