package com.liebe;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * Created by Administrator on 2017/7/31.
 */
@ControllerAdvice
public class ExceptHandle {

    private final static Logger log = LoggerFactory.getLogger(ExceptHandle.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof MyException){
            MyException myException = (MyException) e;
            log.info("自定义异常返回信息:{}",myException.getMessage());
            return Result.error(myException.getCode(),myException.getMessage());
        }else {
            log.error("系统异常：{}",e);
            return Result.error("-1","系统错误");
        }

    }

//    ResponseEntityExceptionHandler

}
