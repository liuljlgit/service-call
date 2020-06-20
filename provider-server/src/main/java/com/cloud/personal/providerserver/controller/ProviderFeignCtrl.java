package com.cloud.personal.providerserver.controller;

import com.cloud.personal.providerserverclient.client.ProviderFeignClient;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderFeignCtrl implements ProviderFeignClient {

    @Override
    public String feignProviderTest() {
        return "feign:provider:test";
    }
}
