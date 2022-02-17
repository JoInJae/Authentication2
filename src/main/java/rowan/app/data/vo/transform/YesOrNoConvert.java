package rowan.app.data.vo.transform;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class YesOrNoConvert implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean input) {
        return (input) ? "Y" : "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String db) {
        return "Y".equals(db);
    }

}
