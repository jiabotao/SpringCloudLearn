package com.example.mybatis.service;

import com.example.mybatis.entity.User;
import com.example.mybatis.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    UserMapper userMapper;

    public List<User> findByName(String name){
        User a= new User();
        a.setName("jiabotao");
        a.setPasswd("liuxiaoxi");
        userMapper.insert(a);
        List<User> user = userMapper.findByName(name);
        return user;
    }
}
