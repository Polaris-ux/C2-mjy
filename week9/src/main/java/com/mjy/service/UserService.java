package com.mjy.service;

import com.mjy.pojo.User;

/**
 * @author
 * @description
 * @create 2021-04-09 20:26
 */
public interface UserService {

    //用户注册
    boolean register(User user);

    //用户登录
    boolean login(String mobile,String password);

    //查询用户信息
    User findUserById(int id);


}
