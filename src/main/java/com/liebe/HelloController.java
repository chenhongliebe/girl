package com.liebe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/7/28.
 */
@RestController
public class HelloController {

    @Autowired
    private TeService tesService;

    @RequestMapping("/")
    public String say(){
        tesService.print();
        return "hello spring boot";
    }
    @RequestMapping("/hello")
    public String sayHello(String name) throws Exception{
        if(name ==null && name ==""){
            return "hello world";
        }else {
         throw new MyException("110","姓名不能为空");
        }
    }
}
