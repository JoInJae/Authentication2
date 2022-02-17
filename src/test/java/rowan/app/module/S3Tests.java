package rowan.app.module;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rowan.app.utils.JwtUtil;
import rowan.app.utils.S3Util;

import java.io.IOException;

@SpringBootTest
public class S3Tests {

    @Autowired
    private S3Util s3Util;

    @Autowired
    private JwtUtil jwtUtil;

    @Test
    void generateTest() throws IOException {


    }

}
