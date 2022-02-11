package rowan.app.util;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import rowan.app.data.type.TokenEnum;

import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtil {

    private static final Long PERIOD_RENEWAL = 1000L * 60 * 60 * 24 * 30;

    private static final String SUBJECT = "(주)로완";

    private final String secret = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";


    public String createAccessToken(){

        return jwtBuilder()
                .setExpiration(new Date(new Date().getTime() + TokenEnum.ACCESS_TOKEN.getExpiredTime()))
                .compact();

    }

    public String createRefreshToken(){

        return jwtBuilder()
                .setExpiration(new Date(new Date().getTime() + TokenEnum.REFRESH_TOKEN.getExpiredTime()))
                .compact();

    }


    private JwtBuilder jwtBuilder(){

        return Jwts.builder().setSubject(SUBJECT).setIssuedAt(new Date()).signWith(Keys.hmacShaKeyFor(Base64.getDecoder().decode(secret)));

    }

}
