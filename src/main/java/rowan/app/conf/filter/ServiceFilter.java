package rowan.app.conf.filter;

import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;
import rowan.app.mvc.service.AppService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@WebFilter(urlPatterns = "/**")
public class ServiceFilter extends OncePerRequestFilter {

    private final AppService appService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String service = request.getHeader("x-api-service");




        filterChain.doFilter(request, response);

    }

}
