package org.example.hbase.controller;

import org.example.hbase.service.HbaseTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@RequestMapping("test")
public class TestController {

    @Resource
    HbaseTemplate hbaseTemplate;

    @GetMapping("/extistTable")
    public Boolean extistTable() throws IOException {
        //hbaseTemplate.createTable("jiabotao","a","b");
        //hbaseTemplate.deleteTable("jiabotao");
      //  hbaseTemplate.addColumnFamily("jiabotao","a","b");
        hbaseTemplate.scan("jiabotao");
       // hbaseTemplate.addColumnFamily("jiabotao","c","d");
        return false;
    }
}
