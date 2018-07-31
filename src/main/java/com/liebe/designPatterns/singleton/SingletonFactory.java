package com.liebe.designPatterns.singleton;

public class SingletonFactory {

    private static Singleton singleton = new Singleton();

    public SingletonFactory() {
    }
//恶汉模式
    public static Singleton getInstance(){

        return SingletonFactory.singleton;

    }
}
