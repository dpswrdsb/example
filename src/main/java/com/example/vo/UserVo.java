package com.example.vo;

import lombok.Data;

/**
 * @ClassName: UserVo
 * @Description: 用于返回前端的数据结构
 * @Author: Mr.Wang <a href="mailto:15998593797@163.com">发送邮件</a>
 * @Date: 2020-05-10 11:18
 */
@Data
public class UserVo {

    /**
     * 账号
     */
    private String account;

    /**
     * 姓名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

}
