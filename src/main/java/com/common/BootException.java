package com.common;

/**
 * Created by zhuzhengping on 2017/3/21.
 * 自定义的异常类
 * 添加一场代码code
 */
public class BootException extends RuntimeException {

    private Integer code;

    public BootException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
