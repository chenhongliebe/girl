package com.liebe;

import java.util.concurrent.Callable;

public class CallableTest implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("call");
        return null;
    }
}
