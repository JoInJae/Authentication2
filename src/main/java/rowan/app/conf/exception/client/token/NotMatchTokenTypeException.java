package rowan.app.conf.exception.client.token;

import rowan.app.conf.exception.CommonException;
import rowan.app.data.type.ResponseType;

public class NotMatchTokenTypeException extends CommonException {

    private static final ResponseType responseType = ResponseType.TOKEN_NOT_MATCH_TYPE;

    public NotMatchTokenTypeException() {
        super(responseType);
    }
    
}
