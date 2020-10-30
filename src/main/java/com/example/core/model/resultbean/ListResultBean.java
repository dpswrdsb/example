package com.example.core.model.resultbean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: ListResultBean
 * @Description:
 * @Author: Mr.Wang <a href="mailto:15998593797@163.com">发送邮件</a>
 * @Date: 2020-05-10 9:50
 */
public class ListResultBean extends ResultBean implements Serializable {
    private static final long serialVersionUID = -8772614104684503631L;

    public ListResultBean(String errorCode, String status) {
        super(errorCode, status);
    }

    private Map<String, Object> content = new HashMap<String,Object>();

    public Map<String, Object> getContent() {
        return content;
    }

    public void setContent(Map<String, Object> content) {
        this.content = content;
    }

    public ListResultBean setData(Object data){
        this.getContent().put("data", data);
        return this;
    }
}
