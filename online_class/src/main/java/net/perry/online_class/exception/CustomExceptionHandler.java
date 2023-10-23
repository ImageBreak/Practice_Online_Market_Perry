package net.perry.online_class.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import net.perry.online_class.utils.JsonData;

/**
 * Perry Class
 * 异常处理类
 */
@ControllerAdvice
public class CustomExceptionHandler {
    
    private final static Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData handle(Exception e){
        logger.error("[ 系统异常 ] {}",e.getMessage());
        if (e instanceof PerryException){
            PerryException perryException = (PerryException) e;
            return JsonData.buildSuccess(perryException);
        }else{
            return JsonData.buildError("全局异常，未知错误");
        }
    }
}
