package com.example.util.properties;

import lombok.Data;

/**
 * @ClassName: PathsProperties
 * @Description:
 * @Author: Mr.Wang <a href="mailto:15998593797@163.com">发送邮件</a>
 * @Date: 2020-05-10 10:07
 */
@Data
public class PathsProperties {

    /**
     * 根路径
     */
    private String rootPath;

    /**
     * 实际路径
     */
    private String fileActualPath;

    /**
     * 图片实际地址
     */
    private String imgActualPath;

    /**
     * 文档实际地址
     */
    private String docActualPath;

    /**
     * 临时文件地址
     */
    private String tempPath;

    /**
     * 永久文件地址
     */
    private String permanentPath;

    /**
     * 预览地址
     */
    private String remoteUploadPath;
}
