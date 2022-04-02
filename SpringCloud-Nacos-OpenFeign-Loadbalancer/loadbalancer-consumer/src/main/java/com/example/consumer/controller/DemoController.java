package com.example.consumer.controller;

import com.example.consumer.feigns.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    ProviderClient providerClient;

    @GetMapping("getInfoByFeign")
    public String getInfoByFeign(){
        return providerClient.getInfo("consumer feign");
    }
}