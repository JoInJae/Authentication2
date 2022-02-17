package rowan.app.data.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class LoginResult {

    @AllArgsConstructor
    @Builder
    @Getter
    public static class Basic{
        private final String access;
        private final String refresh;
    }

}
