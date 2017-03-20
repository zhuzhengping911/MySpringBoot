package com.compont;

/**
 * Created by zhuzhengping on 2017/3/21.
 */
public class Result<T> {

//    error_code
    private Integer code;

//    error_msg
    private String msg;

//    content
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData(Object object) {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
