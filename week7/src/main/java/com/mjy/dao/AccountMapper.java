package com.mjy.dao;

import com.mjy.pojo.Account;

import java.util.List;

/**
 * @author
 * @description
 * @create 2021-03-22 16:20
 */
public interface AccountMapper {

    /**
     * 获取所有账户
     * @return
     */
    List<Account> findAll();

    /**
     * 通过id注销账户
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 向表中插入一条数据
     * @param record
     * @return
     */
    int insert(Account record);

    /**
     * 通过id查询账户
     * @param id
     * @return
     */
    Account selectByPrimaryKey(String id);

    /**
     * 更新Account
     * @param record
     * @return
     */
    int updateByPrimaryKey(Account record);

}
