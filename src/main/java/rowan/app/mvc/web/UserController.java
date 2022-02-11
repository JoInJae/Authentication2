package rowan.app.mvc.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rowan.app.mvc.service.UserService;
import rowan.app.util.KmsUtil;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    private final KmsUtil kmsUtil;

    @GetMapping(value = "/")
    public String index(){

        System.out.println(kmsUtil.generate());

        userService.test();
        return "abc";

    }

}
