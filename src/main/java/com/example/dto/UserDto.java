package com.example.dto;

import com.example.model.SysUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName: UserDto
 * @Description: 用于接受前端的参数
 * @Author: Mr.Wang <a href="mailto:15998593797@163.com">发送邮件</a>
 * @Date: 2020-05-10 11:20
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserDto extends SysUser {

}
