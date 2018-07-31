package com.liebe.designPatterns.simpleFactory;

public class StaticFactory {

    public static Send produceMail(){
        return new MailSender();
    }

    public static Send produceSms(){
        return new SmsSender();
    }


}
