package com.cloud.personal.providerserver.controller;

import com.cloud.personal.providerserver.entity.Product;
import com.cloud.personal.providerserver.service.IProductService;
import com.cloud.personal.providerserverclient.client.ProviderFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderFeignCtrl implements ProviderFeignClient {

    @Autowired
    IProductService productService;

    @Override
    public String feignProviderTest() {
        return "feign:provider:test";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void reduceStock(Integer reduceNum) {
        Product product = productService.selectById(100001L);
        product.setStock(product.getStock() - reduceNum);
        productService.update(product);
    }
}
