package rowan.app;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rowan.app.data.type.TokenType;
import rowan.app.mvc.service.UserService;

import java.util.Date;

@SpringBootTest
class AuthenticationApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {


    }

}
