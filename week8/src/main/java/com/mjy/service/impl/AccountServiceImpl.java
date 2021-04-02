package com.mjy.service.impl;

import com.mjy.dao.AccountMapper;
import com.mjy.pojo.Account;
import com.mjy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author
 * @description
 * @create 2021-03-30 10:13
 */
@Service
@Transactional//加上改注解后自动开启事务，自动实现数据库异常回滚的问题
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    public List<Account> findAll(){
        return accountMapper.findAll();
    }

    public int deleteByPrimaryKey(String id) {
        return accountMapper.deleteByPrimaryKey(id);
    }

    public int insert(Account record){
        return accountMapper.insert(record);
    }

    public Account selectByPrimaryKey(String id){
        return accountMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKey(Account record){
        return accountMapper.updateByPrimaryKey(record);
    }

    public void transfer(String remitterId,String remitteeId,int money){
        //获取转账的账户
        Account account = accountMapper.selectByPrimaryKey(remitterId);
        Account account1 = accountMapper.selectByPrimaryKey(remitteeId);
        //修改账户中的金额
        account.setMoney(account.getMoney()-money);
        accountMapper.updateByPrimaryKey(account);
        //修改数据库中的数据
        account1.setMoney(account1.getMoney()+money);
        accountMapper.updateByPrimaryKey(account1);

    }

}
