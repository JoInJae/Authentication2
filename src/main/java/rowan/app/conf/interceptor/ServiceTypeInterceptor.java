package rowan.app.conf.interceptor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import rowan.app.conf.exception.client.MissingRequiredElementException;
import rowan.app.data.vo.Services;
import rowan.app.mvc.service.AppService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Component
public class ServiceTypeInterceptor implements HandlerInterceptor {

    private final AppService appService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){

        String serviceType = request.getHeader("x-api-service");

        if(serviceType == null){

            throw new MissingRequiredElementException();

        }else{

            Services service = appService.getService(serviceType);

            request.setAttribute("service", service);

        }

        return true;

    }

}
