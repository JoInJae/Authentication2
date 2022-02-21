package rowan.app.conf.interceptor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import rowan.app.conf.exception.client.WrongParameterException;
import rowan.app.data.vo.Services;
import rowan.app.mvc.service.AppService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Component
public class ServiceInterceptor implements HandlerInterceptor {

    private final AppService appService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String service = request.getHeader("x-api-service");

        if(service == null){

            throw new WrongParameterException();

        }else{

            Services services = appService.getService(service);

            request.setAttribute("service", services);

        }

        return true;
    }

}
