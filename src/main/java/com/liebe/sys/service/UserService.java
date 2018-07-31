package com.liebe.sys.service;

import com.liebe.sys.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/10/12.
 */
public interface UserService {

    User getUserById(Integer id);

    List<User> findList(User user);

    void insert(User user);

    User findUserByUserName(String username);

}
