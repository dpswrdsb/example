package com.example.service;

import com.example.vo.User;

public interface LoginService {

     User login(User user);

     User findUserById(String id);
}
