package com.mjy.controller;

import com.mjy.pojo.User;
import com.mjy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author
 * @description
 * @create 2021-04-09 20:27
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //用户注册
    @RequestMapping("/register")
    public String register(@RequestParam("username")String username,
                           @RequestParam("password")String password,
                           @RequestParam("email")String email,
                           @RequestParam("name")String name,
                           @RequestParam("mobile")String mobile,
                           @RequestParam("sex")String sex,
                           @RequestParam("birthday")String birthday) throws ParseException {
        User user = new User();
        System.out.println(sex);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(birthday);
        user.setUserName(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setMobile(mobile);
        user.setSex(sex);
        user.setBirthday(parse);
        user.setName(name);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        System.out.println(birthday);
        boolean register = userService.register(user);
        if(register){
            return "注册成功！！";
        }else{
            return "该手机已注册过,注册失败！！";
        }
    }

    //用户登录
    @RequestMapping("/login")
    public String login(@RequestParam("mobile")String mobile,@RequestParam("password")String password){
        boolean login = userService.login(mobile, password);

        if(login){
            return "登录成功！！";
        }else{
            return "用户名或密码错误";
        }
    }

    //查询用户信息
    @RequestMapping("/findUserById")
    public User findUserById(@RequestParam("id")int id){
        User user = userService.findUserById(id);
        return user;

    }

}
