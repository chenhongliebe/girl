package com.liebe;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/8/18.
 */
@Component
public class ControllerExceptionHandle extends ExceptionHandlerExceptionResolver{

    private static final Logger log = LoggerFactory.getLogger(ControllerExceptionHandle.class);

    @Override
    public ModelAndView doResolveHandlerMethodException(HttpServletRequest request, HttpServletResponse response, HandlerMethod handlerMethod, Exception exception){
        Object result =null;
        response.setCharacterEncoding("gb2312");
        try {
            if(exception instanceof MyException){
                MyException myException = (MyException)exception;
                result = Result.error(myException.getCode(),myException.getMessage());
            }else {
                log.error("系统错误：{}",exception);
                result =  Result.error("-1","系统错误");
            }
            response.getWriter().write(JSON.toJSONString(result));
        }catch (Exception e){
            log.error("异常捕捉失败",e);
            try{
                response.getWriter().write(JSON.toJSONString(result));
            }catch (Exception ex){
                log.error("io异常",ex);
            }
        }
        //异常已处理
        result = new ModelAndView();
        return (ModelAndView) result;
    }

}
