package com.example.consumer.feigns;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "provider")
public interface ProviderClient {

    @GetMapping("getInfo")
    String getInfo(@RequestParam(value = "name",defaultValue = "nacosConfig",required = false)String name);
}