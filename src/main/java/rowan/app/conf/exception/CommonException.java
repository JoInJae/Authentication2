package rowan.app.conf.exception;

import lombok.Getter;
import rowan.app.data.type.ResponseType;

@Getter
public class CommonException extends RuntimeException{

    private final ResponseType responseType;

    private String userId;

    private Object object;

    public CommonException(ResponseType responseType, String userId, Object object){
        this.responseType = responseType;
        this.userId = userId;
        this.object = object;
    }

    public CommonException(ResponseType responseType, String userId){
        this.responseType = responseType;
        this.userId = userId;
    }

    public CommonException(ResponseType responseType){
        this.responseType =responseType;
    }

}
