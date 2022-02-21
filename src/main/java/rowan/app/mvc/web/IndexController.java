package rowan.app.mvc.web;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rowan.app.conf.exception.client.WrongParameterException;
import rowan.app.data.dto.request.LoginParam;
import rowan.app.data.dto.response.Response;
import rowan.app.data.type.ResponseType;
import rowan.app.mvc.service.UserService;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    private Response index(){


        return Response.set(ResponseType.SUCCESS);

    }

    @RequestMapping(value = "/abc", method = RequestMethod.POST)
    private Response test(){

        return Response.set(ResponseType.SUCCESS);

    }

}
