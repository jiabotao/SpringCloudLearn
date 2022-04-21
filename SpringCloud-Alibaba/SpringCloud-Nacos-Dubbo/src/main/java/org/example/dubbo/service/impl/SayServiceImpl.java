package org.example.dubbo.service.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.dubbo.service.SayService;

@DubboService
public class SayServiceImpl implements SayService {

    public String sayHelloByName(String name) {
        return name+",hello!";
    }

}
