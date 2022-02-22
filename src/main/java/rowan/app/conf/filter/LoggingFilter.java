package rowan.app.conf.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@WebFilter(urlPatterns = "/auth")
@RequiredArgsConstructor
public class LoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

        long start = System.currentTimeMillis();

        filterChain.doFilter(requestWrapper, responseWrapper);

        long end = System.currentTimeMillis();

        log.info("\n" +
                        "[REQUEST] [{}] [{}] ({}) {}s \n" +
                        "Headers : {}\n" +
                        "Request : {}\n" +
                        "Response : {}\n",
                (requestWrapper).getMethod(),
                (requestWrapper).getRequestURI(),
                responseWrapper.getStatus(),
                (end - start) / 1000.0,
                getHeaders(request),
                (requestWrapper.getContentAsByteArray().length  > 0) ?
                        new String(requestWrapper.getContentAsByteArray(), StandardCharsets.UTF_8).replaceAll("\r\n", "").replaceAll("\\s+","")
                        : "-",
                (responseWrapper.getContentAsByteArray().length > 0) ?
                        new String(responseWrapper.getContentAsByteArray(), StandardCharsets.UTF_8).replaceAll("\r\n", "").replaceAll("\\s+","")
                        : "-"
        );

        responseWrapper.copyBodyToResponse();

    }

    private Map<Object, Object> getHeaders(HttpServletRequest request) {
        Map<Object, Object> headerMap = new HashMap<>();

        Enumeration<String> headerArray = request.getHeaderNames();
        while (headerArray.hasMoreElements()) {
            String headerName = headerArray.nextElement();
            headerMap.put(headerName, request.getHeader(headerName));
        }
        return headerMap;
    }

}
