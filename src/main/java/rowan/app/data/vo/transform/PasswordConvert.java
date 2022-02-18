package rowan.app.data.vo.transform;

import rowan.app.data.vo.embed.Password;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class PasswordConvert implements AttributeConverter<Password, String> {

    @Override
    public String convertToDatabaseColumn(Password input) {
        return input.getHashedPassword();
    }

    @Override
    public Password convertToEntityAttribute(String db) {
        return new Password(db.substring(0, 64), db.substring(64));
    }

}
