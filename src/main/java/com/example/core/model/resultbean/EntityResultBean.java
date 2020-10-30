package com.example.core.model.resultbean;

/**
 * @ClassName: EntityResultBean
 * @Description:
 * @Author: Mr.Wang <a href="mailto:15998593797@163.com">发送邮件</a>
 * @Date: 2020-05-10 9:49
 */
public class EntityResultBean extends ResultBean {

    private static final long serialVersionUID = -6547955379557192852L;

    private Object content;

    public EntityResultBean(String errorCode, String status) {
        super(errorCode, status);
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public EntityResultBean setEntity(Object data) {
        this.content = data;
        return this;
    }
}
