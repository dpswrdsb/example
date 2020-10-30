package com.example.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.core.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @ClassName: SysUser
 * @Description:
 * @Author: Mr.Wang <a href="mailto:15998593797@163.com">发送邮件</a>
 * @Date: 2020-10-18 12:38
 */

@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_user")
public class SysUser extends BaseModel implements Serializable {
    @TableField(value = "`name`")
    private String name;

    @TableField(value = "account")
    private String account;

    @TableField(value = "`password`")
    private String password;

    private static final long serialVersionUID = 1L;
}
