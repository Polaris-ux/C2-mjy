package com.mjy.dao;

import com.mjy.pojo.Account;

import java.util.List;

/**
 * @author
 * @description
 * @create 2021-03-29 17:48
 */

public interface AccountMapper {
    // 1查询所有记录
    List<Account> findAll();

    // 2通过id删除记录
    int deleteByPrimaryKey(String id);

    //插入数据
    int insert(Account record);

    // 4通过id查找对象
    Account selectByPrimaryKey(String id);

    //5更新Account
    int updateByPrimaryKey(Account record);
}
