package rowan.app.data.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseType {

    SUCCESS(20000, "성공"),

    ERROR(50000, "에러 발생"),

    PARAMETER_WRONG(40001, "잘못된 파라미터"),

    REQUIRED_ELEMENT_MISSING(40002, "필수적인 요소 누락"),

    SERVICE_TYPE_UNKNOWN(40010, "알려지지않은 서비스 유형"),

    TOKEN_INVALID(40101, "토큰 유효성"),

    TOKEN_TIMEOUT(40102, "토큰 시간 초과"),

    TOKEN_NOT_SUPPORT_FORM(40103, "지원하지 않는 토큰 양식"),

    TOKEN_NOT_MATCH_TYPE(40104, "일치하지 않는 토큰 타입"),

    TOKEN_NOT_EXIST(40105, "존재하지 않는 토큰"),

    USER_ID_WRONG(40108, "잘못된 아이디"),

    USER_PASSWORD_WRONG(40109, "잘못된 패스워드"),

    USER_INACTIVE(40110, "비활성화 유저");

    private final Integer code;

    private final String message;

}
