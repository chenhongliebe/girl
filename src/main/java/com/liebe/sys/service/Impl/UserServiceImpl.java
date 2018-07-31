package com.liebe.sys.service.Impl;

import com.liebe.sys.dao.UserMapper;
import com.liebe.sys.entity.User;
import com.liebe.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/10/12.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

   public User getUserById(Integer id){
      return userMapper.selectByPrimaryKey(id);
    }

    public  List<User> findList(User user){
      return userMapper.findList(user);
    }
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED,
        propagation = Propagation.REQUIRED
    )
    public void insert(User user){
        userMapper.insert(user);
    }

    public User findUserByUserName(String username){
        return userMapper.findUserByUserName(username);
    }

}
