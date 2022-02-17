package rowan.app.data.dto.response;

import lombok.Getter;
import rowan.app.data.type.ResponseType;

public class Response {

    @Getter
    private final Integer code;
    @Getter
    private final String message;

    public Response(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Response set(ResponseType responseType){
        return new Response(responseType.getCode(), responseType.getMessage());
    }

    public static Response set(ResponseType responseType, Object body){
        return new Response.Body<>(responseType.getCode(), responseType.getMessage(), body);
    }

    public static class Body<T> extends Response{

        @Getter
        private final T result;

        public Body(Integer code, String message, T result) {
            super(code, message);
            this.result = result;
        }

    }

}
