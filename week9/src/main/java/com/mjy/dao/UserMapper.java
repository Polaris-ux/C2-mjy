package com.mjy.dao;

import com.mjy.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author
 * @description
 * @create 2021-04-09 20:22
 */
public interface UserMapper {

    //用户注册
    void register(User user);

    //用户登录
    User login(@Param("mobile")String mobile,@Param("password") String password);

    //查询用户信息
    User findUserById(@Param("id")int id);

    //查询用户信息
    User findUserByPhone(@Param("mobile")String mobile);

}
