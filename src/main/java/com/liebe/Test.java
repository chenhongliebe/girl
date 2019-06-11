package com.liebe;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Factory;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.aop.Advisor;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.adapter.AdvisorAdapter;
import org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.DispatcherServlet;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    LinkedHashMap linkedHashMap = new LinkedHashMap();



    public static int[] charu(int[] datas){

        for(int i=1;i<datas.length;i++){
            int j =i-1;
            while(datas[j]>datas[j++] && j>0){
                int temp = datas[j++];
                datas[j++] =datas[j];
                datas[j]=temp;
                j--;
            }
        }
        return datas;
    }

    public static int[] xuanzhe(int[] datas){
        for(int i=0;i<datas.length-1;i++){
            int index =i;
            for(int j=i+1;j<datas.length;j++){
                if(datas[index]>datas[j]){
                    index =j;
                }
            }
            if(i!=index){

            }
        }

        return datas;
    }

    public static int[] maopao(int[] datas){
        for(int i=0;i<datas.length-1;i++){
            for(int j=0;j<datas.length-i;j++){
                if(datas[j]>datas[j+1]){
                    int temp = datas[j+1];
                    datas[j+1] =datas[j];
                    datas[j]=temp;
                }
            }
        }
        return datas;
    }

    public static int kuaisu(int[] datas,int left,int right){
        int index=datas[left];
        while(left<right){
            while (left<right && index <=datas[right]){
                right--;
            }
            datas[left] =datas[right];
            while (left<right && index >datas[left]){
                left++;
            }
            datas[right] =datas[left];
        }
        datas[left] =index;
        return left;
    }

    public static void main(String[] args) {
        /**
         * 情景五：
         *  JAVA编译器对string + 基本类型/常量 是当成常量表达式直接求值来优化的。
         *  运行期的两个string相加，会产生新的对象的，存储在堆(heap)中
         */
//        String str6 = "b";
//        String str7 = "a" + str6;
//        String str67 = "ab";
//        System.out.println("str7 = str67 : "+ (str7 == str67));
//        //↑str6为变量，在运行期才会被解析。
//        final String str8 = "b";
//        String str9 = "a" + str8;
//        String str89 = "ab";
//        System.out.println("str9 = str89 : "+ (str9 == str89));
        //↑str8为常量变量，编译期会被优化
        //↑------------------------------------------------------over

//        new SqlSessionFactoryBuilder().build();
//        char c = 'r';
//        int a=c;
//        char b='A';
//        b+=32;
//        String str="中";
//        byte[] bytes =str.getBytes();
//        int e =b;
//        int i =Integer.MAX_VALUE;
//        System.out.println(a);
//        System.out.println(e);
//        System.out.println(b);
//        System.out.println(bytes.length);
//        HashMap s;
//        List list;
//        Comparable comparable;
//        AtomicInteger atomicInteger;
//        MethodBeforeAdvice methodBeforeAdvice;
//        AdvisorAdapter advisorAdapter;
//
//        Properties properties;
////        this.getClass().getClassLoader()
//        try {
//            MethodBeforeAdviceInterceptor methodBeforeAdviceInterceptor;
//        } catch (Exception e1) {
//            e1.printStackTrace();
//        }
//        try {
//            DispatcherServlet dispatcherServlet;
//        } catch (Exception e1) {
//            e1.printStackTrace();
//        }
//        ClassLoader classLoader0 = Test.class.getClassLoader();
//        ClassLoader classLoader = Test.class.getClassLoader().getParent();
//        ClassLoader classLoader1 =classLoader.getParent();
//        ClassLoader c = Integer.class.getClassLoader();
//        System.out.println(c);
//
//        System.out.println(classLoader0);
//        System.out.println(classLoader);
//        System.out.println(classLoader1);
//
//        ThreadPoolExecutor threadPoolExecutor;
//        ExecutorService executorService = Executors.newFixedThreadPool(15);
//        Future future = executorService.submit(new CallableTest());
//        FutureTask future1 = new FutureTask(new CallableTest());
//        Thread thread = new Thread(future1);
//        thread.start();
//        Integer i = new Integer(100);
//        String str = new String("100");
//        String s = new String("100");
//        Long l = new Long(100);
//        System.out.println(str.equals(s));
//        System.out.println(i.equals(str));
//        System.out.println(str.equals(l));
//        System.out.println(i.equals(l));
//        System.out.println(l.equals(i));
//        int a =100;
//        Integer i = 100;
//        Integer i2 =100;
//        Integer i3 = 1000;
//        Integer i4 = 1000;
//        System.out.println(i ==i2);
//        System.out.println(i3 ==i4);
//        System.out.println(i3.equals(i4));
//        System.out.println(i.equals(i2));
//        String s1 ="ab";
//        String s2 ="ab";
//        String s3 ="a"+"b";
//        System.out.println(s1==s2);
        char[] chars ={'a','b','c'};
        char[] s =chars;
        chars[1]='x';
        System.out.println(s);
        String s1 ="ab";
        String s2 =s1;
        s1="cd";
        System.out.println(s2);
//        ExecutorType.BATCH d;
        //cglib 代理原理

//        Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
//                target.getClass().getInterfaces(), this);
        Integer i = Integer.valueOf(10);
        Integer j = new Integer(10);
        Integer k = Integer.valueOf(145);
        Integer p = new Integer(145);
        System.out.println(i==j);
    }



}
