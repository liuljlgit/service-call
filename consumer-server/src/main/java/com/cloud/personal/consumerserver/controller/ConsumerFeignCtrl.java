package com.cloud.personal.consumerserver.controller;

import com.cloud.personal.providerserverclient.client.ProviderFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ConsumerFeignCtrl {

    @Autowired
    ProviderFeignClient providerFeignClient;

    @RequestMapping("/feign/consumer/test")
    public void consumerTest(){
        log.info("log:" + providerFeignClient.feignProviderTest());
    }

}
