package rowan.app.conf.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import rowan.app.conf.exception.client.WrongParameterException;
import rowan.app.data.dto.response.Response;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler({WrongParameterException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response wrong_key_exception(CommonException e){

        return Response.set(e.getResponseType());

    }

}
