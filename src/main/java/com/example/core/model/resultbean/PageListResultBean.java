package com.example.core.model.resultbean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: PageListResultBean
 * @Description:
 * @Author: Mr.Wang <a href="mailto:15998593797@163.com">发送邮件</a>
 * @Date: 2020-05-10 9:51
 */
public class PageListResultBean extends ResultBean implements Serializable {

    private static final long serialVersionUID = 4528095278812656773L;

    private Map<String, Object> content = new HashMap<String,Object>();

    public PageListResultBean(String errorCode, String status) {
        super(errorCode, status);
    }
    public Map<String, Object> getContent() {
        return content;
    }

    public void setContent(Map<String, Object> content) {
        this.content = content;
    }

    public PageListResultBean setData(Object data){
        this.getContent().put("data", data);
        return this;
    }

    public PageListResultBean setTotal(Long total){
        this.getContent().put("total", total);
        return this;
    }

    public PageListResultBean setPageNum(Long pageNum){
        this.getContent().put("pageNum", pageNum);
        return this;
    }

}
