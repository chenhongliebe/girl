package com.liebe.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * Created by Administrator on 2017/7/31.
 */
@Aspect
@Component
public class HttpAspect {

//    @Before("execution(public * com.legalups.sufatong.controller.ThirdInterface.CaseController.*(..))")
//    public void preHandler(){
//        ProceedingJoinPoint pjp
//        Signature s = pjp.getSignature();
//        String name = pjp.getSignature().getName();
//        MethodSignature ms = (MethodSignature)s;
//        Method m = ms.getMethod();
//        System.out.print("11111111");
//    }

    @Pointcut("execution(public * com.liebe.HelloController.*(..))")
    public void pointCut() {
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("after aspect executed");
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        //如果需要这里可以取出参数进行处理
        Object[] args = joinPoint.getArgs();
        System.out.println("before aspect executing");
    }
}
