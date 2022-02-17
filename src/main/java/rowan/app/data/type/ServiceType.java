package rowan.app.data.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ServiceType {

    MEET("연구과제"),

    CENTER("센터"),

    ONE_QUICK("원퀵");
    
    private String text;

}
