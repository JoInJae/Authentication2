package rowan.app.conf.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import rowan.app.conf.exception.client.MissingRequiredElementException;
import rowan.app.conf.exception.client.login.InactiveUserException;
import rowan.app.conf.exception.client.WrongParameterException;
import rowan.app.conf.exception.client.login.WrongUserIdException;
import rowan.app.conf.exception.client.login.WrongUserPasswordException;
import rowan.app.data.dto.response.Response;
import rowan.app.data.type.UserLogType;
import rowan.app.mvc.service.UserService;

@RequiredArgsConstructor
@RestControllerAdvice
public class ControllerAdvice {

    private final UserService userService;

    @ExceptionHandler({WrongParameterException.class, MissingRequiredElementException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response wrong_key_exception(CommonException e){

        return Response.set(e.getResponseType());

    }

    @ExceptionHandler({WrongUserIdException.class, WrongUserPasswordException.class, InactiveUserException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Response login_exception(CommonException e){

        UserLogType userLogType = null;

        switch (e.getResponseType()){
            case USER_ID_WRONG:
                userLogType = UserLogType.FAILED_ID;
                break;
            case USER_PASSWORD_WRONG:
                userLogType = UserLogType.FAILED_PW;
                break;
            case USER_INACTIVE:
                userLogType = UserLogType.DISABLE;
                break;
            default: break;
        }

        //userService.user_log_put(e.getUserId(), null, userLogType, (String)e.getObject());

        return Response.set(e.getResponseType());

    }

}
