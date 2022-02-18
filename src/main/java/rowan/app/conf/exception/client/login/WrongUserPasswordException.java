package rowan.app.conf.exception.client.login;

import rowan.app.conf.exception.CommonException;
import rowan.app.data.type.ResponseType;

public class WrongUserPasswordException extends CommonException {

    private static final ResponseType responseType = ResponseType.USER_PASSWORD_WRONG;

    public WrongUserPasswordException(String id, String password) {
        super(responseType, id, password);
    }
    
}
