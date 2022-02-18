package rowan.app.mvc.web;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import rowan.app.conf.exception.client.WrongParameterException;
import rowan.app.data.dto.request.LoginParam;
import rowan.app.data.dto.response.LoginResult;
import rowan.app.data.dto.response.Response;
import rowan.app.data.type.ResponseType;
import rowan.app.mvc.service.UserService;
import rowan.app.utils.JwtUtil;

import javax.validation.Valid;
import java.lang.invoke.WrongMethodTypeException;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/auth/user")
public class UserController {

    private final UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private Response login(@Valid @RequestBody LoginParam.Basic param, BindingResult bindingResult){

        if(bindingResult.hasErrors()) throw new WrongParameterException();

        return Response.set(ResponseType.SUCCESS, userService.login(param.getId(), param.getPassword()));

    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    private Response logout(){

        return null;

    }

}
