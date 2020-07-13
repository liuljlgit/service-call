package com.cloud.personal.consumerserver;

import com.cloud.personal.servicecallbase.feign.interceptor.global.EnableFeignInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignInterceptor
@EnableAspectJAutoProxy
@ComponentScan("com.cloud")
@MapperScan("com.cloud.**.dao")
@SpringBootApplication(scanBasePackages = {"com.cloud.personal"},exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients(value = {"com.cloud.personal"})
public class ConsumerServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerServerApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
