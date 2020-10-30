package com.example.core.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName: AbstractModel
 * @Description:
 * @Author: Mr.Wang <a href="mailto:15998593797@163.com">发送邮件</a>
 * @Date: 2020-05-10 9:47
 */
@Data
public class AbstractModel {
    /**
     * 主键id.生成策略UUID，类型String
     */
    @TableId(type = IdType.UUID)
    @TableField(value = "ID")
    protected String id;

    /**
     * 删除FLG
     */
    @TableField(value = "DEL_FLAG")
    private String delFlag;

    /**
     * 创建者ID
     */

    @TableField(value = "CREATE_USER_ID")
    private String createUserId;

    /**
     * 创建时间
     */
    @TableField(value = "CREATE_TIME")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 更新者ID
     */
    @TableField(value = "UPDATE_USER_ID")
    private String updateUserId;

    /**
     * 更新时间
     */
    @TableField(value = "UPDATE_TIME")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
