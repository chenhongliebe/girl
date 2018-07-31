package com.liebe.designPatterns.abstractFactory;

import com.liebe.designPatterns.simpleFactory.Send;
import com.liebe.designPatterns.simpleFactory.SmsSender;

public class SmsFactory implements Provider {

    @Override
    public Send produce() {
        return new SmsSender();
    }
}
