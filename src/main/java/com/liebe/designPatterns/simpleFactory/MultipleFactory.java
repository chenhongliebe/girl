package com.liebe.designPatterns.simpleFactory;

import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextListener;

public class MultipleFactory {

    public Send produceMain(){
        return new MailSender();
    }

    public Send produceSms(){
        return new SmsSender();
    }

    ServletContextListener servletContextListener;
    ContextLoaderListener contextLoaderListener = new ContextLoaderListener();


}
