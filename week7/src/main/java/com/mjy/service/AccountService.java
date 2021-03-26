package com.mjy.service;

import com.mjy.pojo.Account;

import java.util.List;

/**
 * @author
 * @description
 * @create 2021-03-26 17:19
 */
public interface AccountService {
    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAll();

    /**
     * 通过用户id注销账户
     * @param id
     */
    void deleteByPrimaryKey(String id);

    /**
     * 向表中插入一条数据
     * @param record
     */
    void insert(Account record);


    /**
     * 通过id查找对象
     * @param id
     * @return
     */
    Account selectByPrimaryKey(String id);

    /**
     * 修改用户信息
     * @param account
     */
    void updateByPrimaryKey(Account account);

    /**
     * 转账
     * @param remitterId
     * @param remitteeId
     * @param money
     */
    void tranfer(String remitterId, String remitteeId, int money);


}
