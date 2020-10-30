package com.example.core.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @ClassName: BaseModel
 * @Description:
 * @Author: Mr.Wang <a href="mailto:15998593797@163.com">发送邮件</a>
 * @Date: 2020-05-10 9:48
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseModel extends AbstractModel {

    /**
     * 页数
     */
    @TableField(exist = false)
    private Integer pageNum;

    /**
     * 每页显示数
     */
    @TableField(exist = false)
    private Integer pageSize;

    /**
     * 主键ID集合
     */
    @TableField(exist = false)
    private List<String> ids;

    /**
     * 排序
     */
    @TableField(exist = false)
    private String sorts;

    /**
     * 获取页数
     *
     * @return PAGE_NUM - 页数
     */
    public Integer getPageNum() {
        if (pageNum == null) {
            return 1;
        }
        return pageNum;
    }

    /**
     * 获取每页显示数
     *
     * @return PAGE_SIZE - 每页显示数
     */
    public Integer getPageSize() {
        if (pageSize == null) {
            return 10;
        }
        return pageSize;
    }
}
