package org.example.jedis;

import redis.clients.jedis.Jedis;

public class Test {
    public static void main(String[] args){
        Jedis jedis = new Jedis("192.168.3.121", 6379);
        System.out.println(jedis.setnx("keys","value"));
    }
}
