package com.shiro.demo.service;

import com.shiro.demo.mapper.UserMapper;
import com.shiro.demo.model.User;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class UserService implements IUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
