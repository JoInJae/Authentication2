package rowan.app.conf;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import rowan.app.conf.interceptor.AuthenticationInterceptor;
import rowan.app.conf.interceptor.ServiceInterceptor;

@RequiredArgsConstructor
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final AuthenticationInterceptor authenticationInterceptor;
    private final ServiceInterceptor serviceInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor).order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/auth/user/login","/abc", "/");

        registry.addInterceptor(serviceInterceptor).order(2)
                .addPathPatterns("/**");

    }

}
