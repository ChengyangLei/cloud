package com.huont.cloud.admin.common.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ControllerAdvice
@Component
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Result validateException(HttpServletRequest request, Exception e) {
        logger.error(e.getMessage(), e);
        return Result.getFailedInstance("[param validate error:]" + (((BindException) e).getBindingResult()).getAllErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result allException(HttpServletRequest request, Exception e) {
        Result result = new Result();
        logger.error(e.getMessage(), e);
        if (e instanceof NullPointerException) {
            return Result.getFailedInstance("[操作中发生了NullPointerException:]" + e.getMessage());
        } else if (e instanceof MethodArgumentNotValidException) {
            List<ObjectError> allErrors = ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors();
            if (!CollectionUtils.isEmpty(allErrors)) {
                StringBuffer sb = new StringBuffer();
                allErrors.forEach((er) -> {
                    sb.append("[").append(((FieldError) er).getField()).append("] : ").append(er.getDefaultMessage()).append(" ");
                });
                return Result.getFailedInstance(sb.toString());
            }

        }
        return Result.getFailedInstance("[the request error:]" + e.getMessage());
    }

}