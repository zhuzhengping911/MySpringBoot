package com.common;

import com.compont.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhuzhengping on 2017/3/21.
 * 异常记录
 * 便于在log中寻找
 */

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result catchFromService(Exception e){
        if(e instanceof BootException){
            BootException bootException = (BootException) e;
            return ResultUtil.error(100,e.getMessage());
        }
        LOGGER.error("【系统异常】{}",e);
        return ResultUtil.error(ExceptionEnum.UNKONW_ERROR);
    }
}
