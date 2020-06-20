package com.cloud.personal.providerserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderRibbonCtrl {

    @RequestMapping("/provider/test")
    public String providerTest(){
        return "provider-server:test";
    }

}
