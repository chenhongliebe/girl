package com.liebe.reflect;


/**
 * Created by Administrator on 2017/8/18.
 */
public class Demo {
    public static void main(String[] args){

        Foo f = new Foo();
        Class cc  =f.getClass();


       Class cc2 = Foo.class;

        try {
            Class cc3 = Class.forName("com.liebe.reflect.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //Foo的实例对象如何表示
        Foo foo1 = new Foo();//foo1就表示出来了.
        //Foo这个类 也是一个实例对象，Class类的实例对象,如何表示呢
        //任何一个类都是Class的实例对象，这个实例对象有三种表示方式

        //第一种表示方式--->实际在告诉我们任何一个类都有一个隐含的静态成员变量class
        Class c1 = Foo.class;
        //第二中表达方式  已经知道该类的对象通过getClass方法
        Class c2 = foo1.getClass();
		/*官网 c1 ,c2 表示了Foo类的类类型(class type)
		 * 万事万物皆对象，
		 * 类也是对象，是Class类的实例对象
		 * 这个对象我们称为该类的类类型
		 *
		 */
        //不管c1  or c2都代表了Foo类的类类型，一个类只可能是Class类的一个实例对象
        System.out.println(c1 == c2);
        //类的类类型第三种方式
        try {
            Class c3 = Class.forName("com.liebe.reflect.Foo");
        }catch (Exception e){
            e.printStackTrace();
        }
        //我们完全可以通过类的类类型创建该类的对象实例---->通过c1 or c2 or c3创建Foo的实例对象
        try{
            Foo foo = (Foo)c1.newInstance();//需要有无参数的构造方法
        }catch (Exception e){
            e.printStackTrace();
        }
        Class c4 = int.class;
        Class c5 = Integer.class;
        Class c6 = double.class;
        Class c7 = Double.class;
        Class c8 = String.class;
        Class c9 = void.class;
        System.out.print(c4.getName());
        System.out.print(c5.getName());
        System.out.print(c6.getName());
        System.out.print(c6.getSimpleName());
        System.out.print(c7.getName());
        System.out.print(c8.getName());
        System.out.print(c9.getName());
    }


}

//class Foo{
//    void print(){
//        System.out.print("foo");
//    }
//}
