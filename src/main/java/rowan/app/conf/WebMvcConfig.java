package rowan.app.conf;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import rowan.app.conf.interceptor.AuthenticationInterceptor;
import rowan.app.conf.interceptor.ServiceTypeInterceptor;

@RequiredArgsConstructor
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final AuthenticationInterceptor authenticationInterceptor;
    private final ServiceTypeInterceptor serviceTypeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(authenticationInterceptor).order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/auth", "/auth/user/login", "/route/**", "/error");

        registry.addInterceptor(serviceTypeInterceptor).order(2)
                .addPathPatterns("/**")
                .excludePathPatterns("/auth","/error");

    }

}
