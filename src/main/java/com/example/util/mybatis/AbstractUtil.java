package com.example.util.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName: AbstractUtil
 * @Description:
 * @Author: Mr.Wang <a href="mailto:15998593797@163.com">发送邮件</a>
 * @Date: 2020-05-10 11:25
 */
public class AbstractUtil {

    /**
     * @param queryWrapper sql对象
     * @param sorts        排序对象
     * @param defaultSort  默认排序列
     * @param <T>          实体对象
     */
    public static <T> void packageQueryWrapper(QueryWrapper<T> queryWrapper, String sorts, String defaultSort) {

        if (StringUtils.isNotEmpty(sorts)) {
            // 驼峰转下划线
            String sort = CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, sorts);

            //页面排序规则
            orderQueryWrapper(queryWrapper, sort);
        }

        if (StringUtils.isNotEmpty(defaultSort)) {

            // 默认排序
            orderQueryWrapper(queryWrapper, defaultSort);
        }
    }

    /**
     * @param queryWrapper sql对象
     * @param sort         排序对象
     * @param <T>          实体对象
     */
    private static <T> void orderQueryWrapper(QueryWrapper<T> queryWrapper, String sort) {
        String horizontalLine = "-";

        if (sort.startsWith(horizontalLine)) {
            queryWrapper.orderByDesc(sort.substring(1));
        } else {
            queryWrapper.orderByDesc(sort);
        }
    }
}
