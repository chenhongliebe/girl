package com.liebe;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/7/28.
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String say(){
        return "hello spring boot";
    }
}
