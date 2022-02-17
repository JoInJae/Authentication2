package rowan.app.data.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserLogType {

    LOGIN("로그인"),

    LOGOUT("로그아웃"),

    FAILED_ID("아이디 틀림"),

    FAILED_PW("패스워드 틀림"),

    DISABLE("비활성화된 유저"),

    CLICK("클릭");

    private String text;

}
