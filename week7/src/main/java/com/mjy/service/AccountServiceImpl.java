package com.mjy.service;

import com.mjy.dao.AccountMapper;
import com.mjy.pojo.Account;
import com.mjy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author
 * @description
 * @create 2021-03-22 22:25
 */
public class AccountServiceImpl implements AccountService {

    /**
     * 查询所有记录
     *
     * @return
     */
    public List<Account> findAll() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        List<Account> records = mapper.findAll();
        sqlSession.close();
        return records;
    }

    /**
     * 通过用户id注销账户
     *
     * @param id
     */
    public void deleteByPrimaryKey(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        int flag = mapper.deleteByPrimaryKey(id);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
        if (flag > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    /**
     * 向表中插入一条数据
     *
     * @param record
     */
    public void insert(Account record) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        int flag = mapper.insert(record);
        sqlSession.commit();
        sqlSession.close();
        if (flag > 0) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }
    }

    /**
     * 通过id查找对象
     *
     * @param id
     * @return
     */
    public Account selectByPrimaryKey(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        Account account = mapper.selectByPrimaryKey(id);
        sqlSession.close();

        return account;
    }

    /**
     * 修改用户信息
     *
     * @param account
     */
    public void updateByPrimaryKey(Account account) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        int flag = mapper.updateByPrimaryKey(account);

        sqlSession.commit();
        sqlSession.close();

        if (flag > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    /**
     * 转账
     * @param remitterId
     * @param remitteeId
     * @param money
     */
    public void tranfer(String remitterId, String remitteeId, int money) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        Account remitter = mapper.selectByPrimaryKey(remitterId);
        Account remittee = mapper.selectByPrimaryKey(remitteeId);
        remitter.setMoney(remitter.getMoney()-money);
        remittee.setMoney(remittee.getMoney()+money);
        mapper.updateByPrimaryKey(remitter);
        mapper.updateByPrimaryKey(remittee);
        sqlSession.commit();
        sqlSession.close();
    }
}
