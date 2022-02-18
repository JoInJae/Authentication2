package rowan.app.conf.exception.client.token;

import rowan.app.conf.exception.CommonException;
import rowan.app.data.type.ResponseType;

public class NotSupportTokenFormException extends CommonException {

    private static final ResponseType responseType = ResponseType.TOKEN_NOT_SUPPORT_FORM;

    public NotSupportTokenFormException() {
        super(responseType);
    }
    
}
