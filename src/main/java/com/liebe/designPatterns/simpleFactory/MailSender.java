package com.liebe.designPatterns.simpleFactory;

public class MailSender implements Send {

    @Override
    public void send() {
        System.out.println("发送短信");
    }
}
