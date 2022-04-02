package org.example.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelWebApplication {

    public static void main(String[] args){
        SpringApplication.run(SentinelWebApplication.class, args);
    }
}
