package com.liebe.sys.dao;

import com.liebe.sys.entity.User;

import javax.annotation.Resource;
import java.util.List;

@Resource
public interface UserMapper {

    User getUserById(Integer id);

    List<User> findList(User user);

    User findUserByUserName(String username);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}