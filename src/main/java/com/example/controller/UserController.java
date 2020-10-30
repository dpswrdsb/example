package com.example.controller;

import com.example.core.model.resultbean.ResultBean;
import com.example.dto.UserDto;
import com.example.service.SysUserService;
import com.example.util.properties.MyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: ExampleController
 * @Description:
 * @Author: Mr.Wang <a href="mailto:15998593797@163.com">发送邮件</a>
 * @Date: 2020-05-10 9:46
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    MyProperties myProperties;

    @Resource
    SysUserService sysUserService;

    @PostMapping("query/list")
    public ResultBean pageList(@RequestBody(required = false) UserDto userDto) {

        System.out.println(myProperties.getPathsProperties().getFileActualPath());

        return sysUserService.pageList(userDto);
    }
}
