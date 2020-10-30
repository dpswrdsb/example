package com.example.util.properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName: StaticProperties
 * @Description:
 * @Author: Mr.Wang <a href="mailto:15998593797@163.com">发送邮件</a>
 * @Date: 2020-05-10 10:36
 */
public class StaticProperties {

    /**
     * 根路径
     */
    public static String rootPath;

    /**
     * 实际路径
     */
    public static String fileActualPath;

    /**
     * 图片实际地址
     */
    public static String imgActualPath;

    /**
     * 文档实际地址
     */
    public static String docActualPath;

    /**
     * 临时文件地址
     */
    public static String tempPath;

    /**
     * 永久文件地址
     */
    public static String permanentPath;

    /**
     * 预览地址
     */
    public static String remoteUploadPath;

    private static StaticProperties staticProperties;

    static {
        staticProperties = loadConfig();
    }

    private static final String PROPERTIES_STR = "develop.properties";

    private static StaticProperties loadConfig() {
        if (staticProperties == null) {
            staticProperties = new StaticProperties();
            Properties properties;
            try {
                properties = PropertiesLoaderUtils.loadAllProperties("application.yml");

                rootPath = properties.getProperty(PROPERTIES_STR + ".paths-properties.root_path");
                fileActualPath = properties.getProperty(PROPERTIES_STR + ".paths-properties.file_actual_path");
                imgActualPath = properties.getProperty(PROPERTIES_STR + ".paths-properties.img_actual_path");
                docActualPath = properties.getProperty(PROPERTIES_STR + ".paths-properties.doc_actual_path");
                tempPath = properties.getProperty(PROPERTIES_STR + ".paths-properties.temp_path");
                permanentPath = properties.getProperty(PROPERTIES_STR + ".paths-properties.permanent_path");
                remoteUploadPath = properties.getProperty(PROPERTIES_STR + ".paths-properties.remote_upload_path");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return staticProperties;
    }

    public StaticProperties getInstance() {
        return staticProperties;
    }
}
