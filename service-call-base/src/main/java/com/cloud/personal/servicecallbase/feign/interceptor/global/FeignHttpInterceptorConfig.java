package com.cloud.personal.servicecallbase.feign.interceptor.global;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * feign拦截器，只包含http相关数据
 */
public class FeignHttpInterceptorConfig {

    protected List<String> requestHeaders = new ArrayList<>();

    @PostConstruct
    public void initialize() {
        requestHeaders.add("user_id");
        requestHeaders.add("user_name");
        requestHeaders.add("access_token");
    }

    /** 使用feign client访问别的微服务时，将上游传过来的access_token、user_id、user_name等信息放入header传递给下一个服务 */
    @Bean
    public RequestInterceptor httpFeignInterceptor() {
        return template -> {
            ServletRequestAttributes attributes =
                    (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (attributes != null) {
                HttpServletRequest request = attributes.getRequest();
                Enumeration<String> headerNames = request.getHeaderNames();
                if (headerNames != null) {
                    String headerName;
                    String headerValue;
                    while (headerNames.hasMoreElements()) {
                        headerName = headerNames.nextElement();
                        if (requestHeaders.contains(headerName)) {
                            headerValue = request.getHeader(headerName);
                            template.header(headerName, headerValue);
                        }
                    }
                }
                // 传递access_token，无网络隔离时需要传递
                String token = extractHeaderToken(request);
                if (StringUtils.isEmpty(token)) {
                    token = request.getParameter("access_token");
                }
                if (!StringUtils.isEmpty(token)) {
                    template.header(HttpHeaders.AUTHORIZATION, "bearer" + " " + token);
                }
            }
        };
    }

    /**
     * 解析head中的token
     *
     * @param request
     */
    private String extractHeaderToken(HttpServletRequest request) {
        Enumeration<String> headers = request.getHeaders(HttpHeaders.AUTHORIZATION);
        while (headers.hasMoreElements()) {
            String value = headers.nextElement();
            if ((value.toLowerCase().startsWith("bearer"))) {
                String authHeaderValue = value.substring("bearer".length()).trim();
                int commaIndex = authHeaderValue.indexOf(',');
                if (commaIndex > 0) {
                    authHeaderValue = authHeaderValue.substring(0, commaIndex);
                }
                return authHeaderValue;
            }
        }
        return null;
    }
}
