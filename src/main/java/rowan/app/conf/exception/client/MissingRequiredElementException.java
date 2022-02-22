package rowan.app.conf.exception.client;

import rowan.app.conf.exception.CommonException;
import rowan.app.data.type.ResponseType;

public class MissingRequiredElementException extends CommonException {

    private static final ResponseType responseType = ResponseType.REQUIRED_ELEMENT_MISSING;

    public MissingRequiredElementException() {
        super(responseType);
    }

}
