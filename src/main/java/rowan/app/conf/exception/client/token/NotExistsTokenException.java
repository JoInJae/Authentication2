package rowan.app.conf.exception.client.token;

import rowan.app.conf.exception.CommonException;
import rowan.app.data.type.ResponseType;

public class NotExistsTokenException extends CommonException {

    private static final ResponseType responseType = ResponseType.TOKEN_NOT_EXIST;

    public NotExistsTokenException() {
        super(responseType);
    }
    
}
