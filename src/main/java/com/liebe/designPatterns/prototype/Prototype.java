package com.liebe.designPatterns.prototype;

import java.io.*;

//原型模式 实现cloneable 复写clone方法
public class Prototype implements Cloneable{

    private static final long serialVersionUID = 1L;

    private String string;


    private SerializableObject obj;

    public Prototype() {
        this.string = "12";
    }

    //todo 浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的。
    //todo 深复制：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。
    // todo 简单来说，就是深复制进行了完全彻底的复制，而浅复制不彻底。
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Prototype prototype =(Prototype) super.clone();
        return prototype;
    }

    //todo 深复制  错误
    public Object deepClone() throws IOException,ClassNotFoundException {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return objectInputStream.readObject();
    }


    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public SerializableObject getObj() {
        return obj;
    }

    public void setObj(SerializableObject obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "Prototype{" +
                "string='" + string + '\'' +
                '}';
    }



    class SerializableObject implements Serializable {
        private static final long serialVersionUID = 1L;
    }



    public static void main(String[] args)throws Exception{

        Prototype prototype = new Prototype();
        Prototype o =(Prototype)prototype.deepClone();
        System.out.println(o.toString());


    }
}
