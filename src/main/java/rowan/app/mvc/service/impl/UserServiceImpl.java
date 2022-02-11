package rowan.app.mvc.service.impl;

import org.springframework.stereotype.Service;
import rowan.app.mvc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void test() {
        System.out.println("aaaaaaaaa");
    }
}
