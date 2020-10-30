package com.example.service;

import com.example.core.model.resultbean.ResultBean;
import com.example.dto.UserDto;
import com.example.model.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @ClassName: SysUserService
 * @Description:
 * @Author: Mr.Wang <a href="mailto:15998593797@163.com">发送邮件</a>
 * @Date: 2020-05-10 11:14
 */

public interface SysUserService extends IService<SysUser> {

    /**
     * 分页
     *
     * @param userDto 参数
     * @return
     */
    ResultBean pageList(UserDto userDto);
}



