package com.example.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Value("${server.port}")
    String port;

    @GetMapping("getInfo")
    public String getInfo(@RequestParam(value = "name",defaultValue = "nacosConfig",required = false)String name){
        return "my name is "+name+",my port is "+port;
    }
}