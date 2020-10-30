package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.constant.CodeConstant;
import com.example.constant.Constant;
import com.example.constant.MessageConstant;
import com.example.core.model.resultbean.PageListResultBean;
import com.example.core.model.resultbean.ResultBean;
import com.example.dto.UserDto;
import com.example.util.asset.AbstractAssertion;
import com.example.util.mybatis.AbstractUtil;
import com.example.vo.UserVo;
import com.example.mapper.SysUserMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.model.SysUser;
import com.example.service.SysUserService;

/**
 * @ClassName: SysUserServiceImpl
 * @Description:
 * @Author: Mr.Wang <a href="mailto:15998593797@163.com">发送邮件</a>
 * @Date: 2020-05-10 11:14
 */

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    SysUserMapper sysUserMapper;

    @Override
    public ResultBean pageList(UserDto userDto) {

        // 将当前页码与每页显示数赋给LONG类型变量
        long pageNum = Long.valueOf(userDto.getPageNum());
        long pageSize = Long.valueOf(userDto.getPageSize());

        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();

        // 参数拼接
        queryWrapper.eq("sys_user.del_flag", CodeConstant.DELETE_FLAG_NO);
        //不查询最高级别的系统管理员
        queryWrapper.notIn("sys_user.account", "admin");
        queryWrapper.eq(StringUtils.isNotEmpty(userDto.getAccount()), "account", userDto.getAccount());

        // 排序
        AbstractUtil.packageQueryWrapper(queryWrapper, userDto.getSorts(), "sys_user.create_time");

        // 分页查询信息,两种方式
        // 1.单表操作时
        IPage<SysUser> userPage = sysUserMapper.selectPage(new Page<>(pageNum, pageSize), queryWrapper);
        if (pageNum != 1 && !AbstractAssertion.notEmpty(userPage.getRecords())) {
            userPage = sysUserMapper.selectPage(new Page<>(pageNum - 1, pageSize), queryWrapper);
        }
//
//        // 2.多表关联时
//        Page<SysUser> userPage = new Page<>(pageNum, pageSize);

//        List<UserVo> list = sysUserMapper.pageList(userPage, queryWrapper);
//        // 当前页为空时，返回上一页
//        if (pageNum != 1 && !AbstractAssertion.notEmpty(list)) {
//            pageNum = pageNum - 1;
//            userPage = new Page<>(pageNum, pageSize);
//            list = sysUserMapper.pageList(userPage, queryWrapper);
//        }

        //返回结果封装
        PageListResultBean pageListResultBean = new PageListResultBean(CodeConstant.RESULT_CODE_SUCCESS, Constant.RESULT_SUCCESS);
        pageListResultBean.setTotal(userPage.getTotal());
        pageListResultBean.setPageNum(pageNum);
        pageListResultBean.setMessage(MessageConstant.COMMON_RESULT_SUCCESS);
        pageListResultBean.setData(userPage.getRecords());

        logger.info("【info】SysUserServiceImpl==pageList()::end");

        return pageListResultBean;
    }
}



