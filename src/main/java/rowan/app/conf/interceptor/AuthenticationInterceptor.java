package rowan.app.conf.interceptor;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import rowan.app.conf.exception.client.token.NotMatchTokenTypeException;
import rowan.app.conf.exception.client.token.NotSupportTokenFormException;
import rowan.app.conf.exception.client.token.TokenTimeoutException;
import rowan.app.conf.exception.client.token.TokenValidException;
import rowan.app.utils.JwtUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    private final JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        System.out.println(request.getServletPath());
        System.out.println(" PATH  ");
        String authorization = request.getHeader("Authorization");

        if(authorization != null && authorization.startsWith("Bearer ")){

            try{

                String token = authorization.substring(7);

                Claims claims = jwtUtil.parse(token).getBody();

                String tokenType = (String) claims.get("type");

                String userId = (String) claims.get("userId");

                if("/auth/user/reissue".equals(request.getServletPath())){

                    if(!"refresh".equals(tokenType)) throw new NotMatchTokenTypeException();

                }else{

                    if(!"access".equals(tokenType)) throw new NotMatchTokenTypeException();

                }

                request.setAttribute("userId", userId);

            }catch (UnsupportedJwtException | MalformedJwtException e){
                throw new TokenValidException();
            }catch (ExpiredJwtException e){
                throw new TokenTimeoutException();
            }

        }else{
            throw new NotSupportTokenFormException();
        }

        return true;

    }

}
