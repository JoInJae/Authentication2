package rowan.app.data.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;


public class LoginParam {

    @AllArgsConstructor
    @Getter
    public static class Basic{

        @NotBlank
        private final String id;

        @NotBlank
        private final String password;

    }

}
