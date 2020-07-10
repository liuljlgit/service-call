package com.cloud.personal.servicecallbase.feign.interceptor.client;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(FeignOAuth2RequestInterceptor.class)
public @interface FeignOAuth2RequestInterceptorAnnotation {

}
