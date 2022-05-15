package org.example.redisson.controller;

import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/RedissonLock")
public class RedissonLockController {

    @Resource
    RedissonClient redissonClient;

    @GetMapping("/getLock")
    public String getLock(){
        //RLock lock = redissonClient.getLock("locak_Key");
        RBucket<String> bucket = redissonClient.getBucket("key");
        return bucket.get();
    }
}
