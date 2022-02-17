package rowan.app.utils;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import rowan.app.conf.key.JwtDataKey;
import rowan.app.data.type.TokenType;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private static final Long PERIOD_RENEWAL = 1000L * 60 * 60 * 24 * 30;

    private static final String SUBJECT = "(주)로완";


    public String createAccessToken(String userId){

        Map<String, String> claims = new HashMap<>(){{
           put("userId", userId);
           put("type", "access");
        }};

        return jwtBuilder()
                .setExpiration(new Date(new Date().getTime() + TokenType.ACCESS_TOKEN.getExpiredTime()))
                .setClaims(claims)
                .compact();

    }

    public String createRefreshToken(String userId){

        Map<String, String> claims = new HashMap<>(){{
            put("userId", userId);
            put("type", "refresh");
        }};

        return jwtBuilder()
                .setExpiration(new Date(new Date().getTime() + TokenType.REFRESH_TOKEN.getExpiredTime()))
                .setClaims(claims)
                .compact();

    }

    private JwtBuilder jwtBuilder(){
        return Jwts.builder().setSubject(SUBJECT).setIssuedAt(new Date()).signWith(Keys.hmacShaKeyFor(Base64.getDecoder().decode(JwtDataKey.getInstance().getSecret())));
    }

}
