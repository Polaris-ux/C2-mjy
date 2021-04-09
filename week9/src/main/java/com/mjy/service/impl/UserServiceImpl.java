package com.mjy.service.impl;

import com.mjy.dao.UserMapper;
import com.mjy.pojo.User;
import com.mjy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author
 * @description
 * @create 2021-04-09 20:54
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean register(User user) {
        if(userMapper.findUserByPhone(user.getMobile())!=null){
            return false;
        }else{
            userMapper.register(user);
            return true;
        }
    }

    @Override
    public boolean login(String mobile, String password) {
        User user = userMapper.login(mobile, password);
        if(user!=null){
            return true;
        }else{
            return false;
        }
    }


    @Override
    public User findUserById(int id) {
        return userMapper.findUserById(id);
    }
}
