package com.liebe.agent;

import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxySubject implements InvocationHandler {

    private Object target;

    public ProxySubject(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(target,args);
        System.out.println("after");
        return result;
    }

    public static void main(String[] args) {
        UserService proxy = (UserService)Proxy.newProxyInstance(UserServiceImpl.class.getClassLoader(),
                UserServiceImpl.class.getInterfaces(),
                new ProxySubject(new UserServiceImpl()));
        proxy.sayHello();
        Class[] c =UserServiceImpl.class.getInterfaces();
        for(Class cc:c){
            System.out.println(cc.getName());
        }
        System.out.println(proxy.getClass().getName());

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(new MyMethodInterceptor());
        UserService userService =(UserService) enhancer.create();
        userService.sayHello();
    }
}
