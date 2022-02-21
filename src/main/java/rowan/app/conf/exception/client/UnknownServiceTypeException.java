package rowan.app.conf.exception.client;

import rowan.app.conf.exception.CommonException;
import rowan.app.data.type.ResponseType;

public class UnknownServiceTypeException extends CommonException {

    private static final ResponseType responseType = ResponseType.SERVICE_TYPE_UNKNOWN;

    public UnknownServiceTypeException() {
        super(responseType);
    }
    
}
