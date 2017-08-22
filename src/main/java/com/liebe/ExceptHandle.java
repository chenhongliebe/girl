package com.liebe;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by Administrator on 2017/7/31.
 */
//@ControllerAdvice
//public class ExceptHandle {
//
//    private final static Logger logger = LoggerFactory.getLogger(ExceptHandle.class);
//
//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public Result handle(Exception e){
//        if(e instanceof MyException){
//            MyException myException = (MyException) e;
//            return Result.error(myException.getCode(),myException.getMessage());
//        }else {
//            logger.error("系统异常：{}",e);
//            return Result.error("-1","系统错误");
//        }
//
//    }
//}
