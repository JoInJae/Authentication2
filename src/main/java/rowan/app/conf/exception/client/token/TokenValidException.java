package rowan.app.conf.exception.client.token;

import rowan.app.conf.exception.CommonException;
import rowan.app.data.type.ResponseType;

public class TokenValidException extends CommonException {

    private static final ResponseType responseType = ResponseType.TOKEN_INVALID;

    public TokenValidException() {
        super(responseType);
    }
    
}
