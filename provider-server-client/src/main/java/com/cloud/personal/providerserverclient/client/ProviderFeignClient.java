package com.cloud.personal.providerserverclient.client;

import com.cloud.personal.providerserverclient.constant.ServiceNameConst;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = ServiceNameConst.SERVICE_PROVIDER_SERVER)
public interface ProviderFeignClient {

    @GetMapping("feign/provider/test")
    String feignProviderTest();

}
