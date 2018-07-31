package com.liebe.designPatterns.simpleFactory;

public class MultipleFactory {

    public Send produceMain(){
        return new MailSender();
    }

    public Send produceSms(){
        return new SmsSender();
    }


}
