package org.example.elasticsearch.service;

import org.example.elasticsearch.esentity.UserEntity;
import org.example.elasticsearch.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    UserRepository userRepository;

    public void test(){
        UserEntity entity = new UserEntity();
        entity.setName("jiabotao");
        entity.setUserId(1L);
        userRepository.save(entity);
    }
}
