package com.liebe.designPatterns.simpleFactory;

//todo 简单工厂模式
public class SenderFactory {

    public Send produce(String type){

        if("mail".equals(type)){
            return new MailSender();
        }else if("sms".equals(type)){
            return new SmsSender();
        }else {
            System.out.println("请输入正确的类型");
            return null;
        }

    }

    public Send produceMail(){
        return new MailSender();
    }

    public Send produceSms(){
        return new SmsSender();
    }

//    public static Send produceMail(){
//        return new MailSender();
//    }
//
//    public static Send produceSms(){
//        return new SmsSender();
//    }




}
