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
        UserTestService proxy = (UserTestService)Proxy.newProxyInstance(UserTestServiceImpl.class.getClassLoader(),
                UserTestServiceImpl.class.getInterfaces(),
                new ProxySubject(new UserTestServiceImpl()));
        proxy.sayHello();
        Class[] c = UserTestServiceImpl.class.getInterfaces();
        for(Class cc:c){
            System.out.println(cc.getName());
        }
        System.out.println(proxy.getClass().getName());

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserTestServiceImpl.class);
        enhancer.setCallback(new MyMethodInterceptor());
        UserTestService userService =(UserTestService) enhancer.create();
        userService.sayHello();
    }
}
