package com.huotn.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author:leichengyang
 * @desc:com.huotn.cloud.gateway
 * @date:2020-08-24
 */
@SpringBootApplication
@EnableZuulProxy
public class CloudServerGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudServerGateWayApplication.class,args);
    }
}
