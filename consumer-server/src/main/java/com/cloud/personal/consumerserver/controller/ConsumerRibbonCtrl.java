package com.cloud.personal.consumerserver.controller;

import com.cloud.personal.providerserverclient.constant.ServiceNameConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class ConsumerRibbonCtrl {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/ribbon/consumer/test")
    public void consumerTest(){
        String URL = ServiceNameConst.HTTP_PREFIX + ServiceNameConst.SERVICE_PROVIDER_SERVER + "/provider/test";
        log.info("log:" + restTemplate.getForEntity(URL,String.class).getBody());
    }

}
