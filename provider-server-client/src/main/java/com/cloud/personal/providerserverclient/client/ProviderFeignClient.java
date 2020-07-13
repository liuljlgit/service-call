package com.cloud.personal.providerserverclient.client;

import com.cloud.personal.providerserverclient.constant.ServiceNameConst;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignOAuth2RequestInterceptorAnnotation
@FeignClient(value = ServiceNameConst.SERVICE_PROVIDER_SERVER/**,configuration = FeignOAuth2RequestInterceptor.class*/)
public interface ProviderFeignClient {

    @GetMapping("feign/provider/test")
    String feignProviderTest();

    @GetMapping("feign/reduce/stock")
    void reduceStock(@RequestParam("reduceNum") Integer reduceNum);

}
