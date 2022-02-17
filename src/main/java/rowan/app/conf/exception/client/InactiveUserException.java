package rowan.app.conf.exception.client;

import rowan.app.conf.exception.CommonException;
import rowan.app.data.type.ResponseType;

public class InactiveUserException extends CommonException {

    private static final ResponseType responseType = ResponseType.PARAMETER_WRONG;

    public InactiveUserException(String id) {
        super(responseType, id);
    }
    
}
