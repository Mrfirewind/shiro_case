package com.shiro.demo.mapper;

import com.shiro.demo.model.User;

public interface UserMapper {

    User findByUsername(String username);
}
