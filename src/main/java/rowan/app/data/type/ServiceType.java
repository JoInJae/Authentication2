package rowan.app.data.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ServiceType {

    HOSPITAL("병의원"),

    RCT("연구과제"),

    CENTER("센터"),

    ONE_QUICK("원퀵");
    
    private String text;

}
