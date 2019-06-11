package com.liebe.agent;

import org.springframework.stereotype.Service;

@Service
public class UserTestServiceImpl implements UserTestService {

    @Override
    public void sayHello() {
        System.out.println("hello");
    }
}
