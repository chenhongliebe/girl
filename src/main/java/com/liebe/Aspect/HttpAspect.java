package com.liebe.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/7/31.
 */
@Aspect
@Component
public class HttpAspect {

    @Before("execution(public * com.liebe.HelloController.*(..))")
    public void preHandler(){
        System.out.println("111");
    }
}
