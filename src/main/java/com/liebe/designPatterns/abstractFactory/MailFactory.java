package com.liebe.designPatterns.abstractFactory;

import com.liebe.designPatterns.simpleFactory.MailSender;
import com.liebe.designPatterns.simpleFactory.Send;

public class MailFactory implements Provider {

    @Override
    public Send produce() {
        return new MailSender();
    }
}
