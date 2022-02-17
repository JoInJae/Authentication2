package rowan.app.data.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseType {

    SUCCESS(20000, "성공"),

    PARAMETER_WRONG(40001, "잘못된 파라미터"),

    USER_ID_WRONG(40108, "잘못된 아이디"),

    USER_PASSWORD_WRONG(40109, "잘못된 패스워드"),

    USER_INACTIVE(40110, "비활성화 유저");

    private final Integer code;

    private final String message;

}
