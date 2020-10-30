package com.example.service.impl;

import com.example.mapper.LoginMapper;
import com.example.service.LoginService;
import com.example.vo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    LoginMapper loginMapper;

    @Override
    public User login(User user) {
        User result = loginMapper.check(user);
        return result;
    }

    @Override
    public User findUserById(String id) {
        User user = loginMapper.findUserById(id);
        return user;
    }
}
