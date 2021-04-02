package com.mjy.service;

import com.mjy.pojo.Account;

import java.util.List;

/**
 * @author
 * @description
 * @create 2021-03-30 12:05
 */
public interface AccountService {

    List<Account> findAll();

    int deleteByPrimaryKey(String id);

    int insert(Account record);

    Account selectByPrimaryKey(String id);

    int updateByPrimaryKey(Account record);

    void transfer(String remitterId,String remitteeId,int money);


}
