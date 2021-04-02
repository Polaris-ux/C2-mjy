package com.mjy.controller;

import com.mjy.pojo.Account;
import com.mjy.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author
 * @description
 * @create 2021-03-30 10:29
 */
@Controller
@ResponseBody //返回报文而不是跳转或重定向
public class AccountController {
    //注入Spring
    @Autowired
    private AccountServiceImpl accountServiceImpl;

    //查询所有用户
    @RequestMapping("/account/all")
    public List<Account> findAll(){
        return accountServiceImpl.findAll();
    }

    //删除用户
    @RequestMapping("/account/deleteById")
    public void deleteById(@RequestParam("id")String id){
        accountServiceImpl.deleteByPrimaryKey(id);
    }

    @RequestMapping("/account/save")
    public void saveUser(@RequestBody Account record){
        accountServiceImpl.insert(record);
    }

    @RequestMapping("/account/select")
    public Account selectById(@RequestParam("id")String id){
        return accountServiceImpl.selectByPrimaryKey(id);
    }

    @RequestMapping("/account/update")
    public void update(@RequestBody Account record){
        accountServiceImpl.updateByPrimaryKey(record);
    }

    @RequestMapping("account/transfer")
    public void transfer(@RequestParam("remitterId") String remitterId,
                         @RequestParam("remitteeId") String remitteeId,
                         @RequestParam("money") int money){
        accountServiceImpl.transfer(remitterId,remitteeId,money);
    }



}
