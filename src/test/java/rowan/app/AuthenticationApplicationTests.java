package rowan.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import rowan.app.data.type.TokenEnum;

import java.util.Date;

@SpringBootTest
class AuthenticationApplicationTests {

    @Test
    void contextLoads() {

        Date date = new Date();

        System.out.println(new Date(date.getTime() + TokenEnum.ACCESS_TOKEN.getExpiredTime()));


        System.out.println(new Date(new Date().getTime() + TokenEnum.ACCESS_TOKEN.getExpiredTime()));

    }

}
