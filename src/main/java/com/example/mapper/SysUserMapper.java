package com.example.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;import com.baomidou.mybatisplus.extension.plugins.pagination.Page;import com.example.model.SysUser;import com.example.vo.UserVo;import org.apache.ibatis.annotations.Param;import java.util.List;

/**
 * @ClassName: SysUserMapper
 * @Description:
 * @Author: Mr.Wang <a href="mailto:15998593797@163.com">发送邮件</a>
 * @Date: 2020-10-18 12:38
 */

public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 分页
     *
     * @param page         分页条件
     * @param queryWrapper 参数条件
     * @return list集合
     */
    List<UserVo> pageList(Page<SysUser> page, @Param(Constants.WRAPPER) QueryWrapper<SysUser> queryWrapper);
}