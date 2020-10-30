package com.example.controller;

import com.example.service.GetTokenService;
import com.example.service.LoginService;
import com.example.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginControllor {

    @Autowired
    LoginService loginService;

    @Autowired
    GetTokenService getTokenService;

    @PostMapping("/check")
    public Map check(@RequestBody User user) {
        Map map = new HashMap();
        User result = loginService.login(user);
        if (result != null) {
            String token = getTokenService.getToken(result);
            map.put("token", token);
        }
        map.put("user", result);
        return map;
    }

    @GetMapping("/findById")
    public User findById(String id) {
        User user = loginService.findUserById(id);
        return user;
    }
}
