package com.example.core.model.resultbean;

/**
 * @ClassName: ResultBean
 * @Description:
 * @Author: Mr.Wang <a href="mailto:15998593797@163.com">发送邮件</a>
 * @Date: 2020-05-10 9:50
 */
public class ResultBean {

    private static final long serialVersionUID = -4501471354564365981L;

    private String errorCode;

    private String message;

    private String status;

    public ResultBean(String errorCode, String status) {
        this.errorCode = errorCode;
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public ResultBean setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
