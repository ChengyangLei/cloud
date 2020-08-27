package com.huotn.cloud.resource.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:leichengyang
 * @desc:com.huotn.cloud.api.config   异常错误通用处理器
 * @date:2020-08-13
 */
@RestControllerAdvice
public class ErrorHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Map<String,Object> handle(Exception e){
        Map<String, Object> map = new HashMap<>();
        map.put("message",e.getMessage());
        map.put("timestamp",new Date().getTime());
        return map;
    }

}
