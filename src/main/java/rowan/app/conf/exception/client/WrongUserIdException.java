package rowan.app.conf.exception.client;

import rowan.app.conf.exception.CommonException;
import rowan.app.data.type.ResponseType;

public class WrongUserIdException extends CommonException {

    private static final ResponseType responseType = ResponseType.PARAMETER_WRONG;

    public WrongUserIdException(String id) {
        super(responseType, id);
    }
    
}
