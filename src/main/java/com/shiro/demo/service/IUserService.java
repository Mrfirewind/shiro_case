package com.shiro.demo.service;

import com.shiro.demo.model.User;

public interface IUserService {

    public User findByUsername(String username);
}
