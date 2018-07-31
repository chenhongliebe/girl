package com.liebe.sys.web;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liebe.Result;
import com.liebe.sys.entity.User;
import com.liebe.sys.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/10/12.
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("get")
    public Result<User> getUser(Integer id){
        User user =userService.getUserById(id);
        return Result.success(user);
    }



    @RequestMapping("list")
    public String findList(User user){
        Page<Object> page =PageHelper.startPage(1,2);
        List<User> list = userService.findList(user);
        PageInfo pageInfo = new PageInfo(list);
        log.info("PageInfo: {}",JSON.toJSONString(pageInfo));
//        return Result.success(pageInfo);
        return "PageInfo: " + JSON.toJSONString(pageInfo);
    }
}
