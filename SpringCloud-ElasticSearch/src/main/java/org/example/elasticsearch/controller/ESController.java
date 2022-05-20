package org.example.elasticsearch.controller;

import org.example.elasticsearch.esentity.Item;
import org.example.elasticsearch.esentity.UserEntity;
import org.example.elasticsearch.service.ItemService;
import org.example.elasticsearch.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@RequestMapping("ESController")
public class ESController {

    @Resource
    UserService userService;

    @GetMapping("/extistTable")
    public String extistTable() throws IOException {

        userService.test();
        return "";
    }
}
