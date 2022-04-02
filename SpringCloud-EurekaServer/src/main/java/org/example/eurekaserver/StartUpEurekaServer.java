package org.example.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer // 加上启用Eureka服务注解（标记其为Eureka服务）
@SpringBootApplication
public class StartUpEurekaServer {

    public static void main(String[] args) {
        SpringApplication.run(StartUpEurekaServer.class,args);
    }
}
