package com.example.util.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MyProperties
 * @Description:
 * @Author: Mr.Wang <a href="mailto:15998593797@163.com">发送邮件</a>
 * @Date: 2020-05-10 10:14
 */
@ConfigurationProperties(prefix="develop.properties")
@Configuration
public class MyProperties {

    private PathsProperties pathsProperties = new PathsProperties();

    public PathsProperties getPathsProperties() {
        return pathsProperties;
    }

    public void setPathsProperties(PathsProperties pathsProperties) {
        this.pathsProperties = pathsProperties;
    }
}
