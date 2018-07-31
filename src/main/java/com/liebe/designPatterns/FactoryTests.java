package com.liebe.designPatterns;

import com.liebe.designPatterns.abstractFactory.MailFactory;
import com.liebe.designPatterns.abstractFactory.Provider;
import com.liebe.designPatterns.builder.BuilderComputerImpl;
import com.liebe.designPatterns.builder.Computer;
import com.liebe.designPatterns.builder.Director;
import com.liebe.designPatterns.prototype.Prototype;
import com.liebe.designPatterns.simpleFactory.MultipleFactory;
import com.liebe.designPatterns.simpleFactory.Send;

public class FactoryTests {



    public static void main (String[] arg) throws Exception{
//普通工厂
//        SenderFactory senderFactory = new SenderFactory();
//        Send s =senderFactory.produce("mail");
//        s.send();
//多个工厂方法模式
//        MultipleFactory factory = new MultipleFactory();
//        Send s =factory.produceSms();
//        s.send();
//静态工厂方法
//        Send send = StaticFactory.produceMail();
//        send.send();
//抽象工厂模式 其实这个模式的好处就是，如果你现在想增加一个功能：
// 发及时信息，则只需做一个实现类，实现Sender接口，同时做一个工厂类，实现Provider接口
// ，就OK了，无需去改动现成的代码。这样做，拓展性较好！
//        Provider provider = new MailFactory();
//        Send send = provider.produce();
//        send.send();

//建造者模式
//        Director director = new Director();
//        Computer computer =director.createComputerByDirector(new BuilderComputerImpl());
//        System.out.println(computer.getMainboard());
//        System.out.println(computer.getCpu());
//        System.out.println(computer.getHd());
//        System.out.println(computer.getMemory());


    }
}
