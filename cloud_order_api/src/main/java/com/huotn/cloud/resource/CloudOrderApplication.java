package com.huotn.cloud.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class CloudOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudOrderApplication.class, args);
    }

}
