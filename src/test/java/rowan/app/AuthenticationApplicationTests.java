package rowan.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import rowan.app.data.type.TokenType;

import java.util.Date;

@SpringBootTest
class AuthenticationApplicationTests {

    @Test
    void contextLoads() {

        Date date = new Date();

        System.out.println(new Date(date.getTime() + TokenType.ACCESS_TOKEN.getExpiredTime()));


        System.out.println(new Date(new Date().getTime() + TokenType.ACCESS_TOKEN.getExpiredTime()));

    }

}
