1.jar包统一加到pom.xml中，尽量不要使用第三方jar。

2.配置文件写在 application.yml中

3.在实体类中要使用@Data注解，开发工具一定要安装Lombok插件

4.数据库连接要自己去填写。在application.yml中配置
    
    示例：
         url: jdbc:mysql://ip:port/数据库名?autoRec&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
         username: 数据库连接用户名
         password: 数据库连接密码
项目目录结构

    main
        java
            com.example.develop
                config  全局配置类
                constant 常量
                controller 业务controller
                core 
                    controller 共通controller
                    model 共通实体类
                dto 接受前端请求的参数bean
                mapper dao层
                model 与数据库表对应的实体类
                service 接口类
                    impl 接口实现类
                util 共通工具类
                vo 后端返回给前端的bean
                DevelopApplication 启动类
                
        resources
            export 导出文件xml模板
            mybatis sql文件(xml)
            templates 文件模板地址
            application.yml 配置文件
    
