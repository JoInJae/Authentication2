package rowan.app.data.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseType {

    SUCCESS(20000, "성공"),

    PARAMETER_WRONG(40001, "잘못된 파라미터");

    private final Integer code;

    private final String message;

}
