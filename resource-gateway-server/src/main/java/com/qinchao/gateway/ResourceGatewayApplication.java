package com.qinchao.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ResourceGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResourceGatewayApplication.class, args);
    }
}
