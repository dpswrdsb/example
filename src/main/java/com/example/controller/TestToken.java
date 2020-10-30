package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.service.GetTokenService;
import com.example.service.LoginService;
import com.example.util.annotation.UserLoginToken;
import com.example.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author WangRui
 */
@RestController
@RequestMapping("/testToken")
public class TestToken {

    @Autowired
    LoginService loginService;

    @Autowired
    GetTokenService getTokenService;

    @PostMapping("/login")
    public Object login(String id){
        JSONObject jsonObject=new JSONObject();
        User userForBase=loginService.findUserById(id);
        if(userForBase==null) {
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        } else {
            String token = getTokenService.getToken(userForBase);
            jsonObject.put("token", token);
            jsonObject.put("user", userForBase);
            return jsonObject;
        }
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }

}
