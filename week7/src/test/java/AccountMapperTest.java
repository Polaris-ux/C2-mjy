import com.mjy.dao.AccountMapper;
import com.mjy.pojo.Account;
import com.mjy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author
 * @description
 * @create 2021-03-22 21:32
 */
public class AccountMapperTest {

    @Test
    public void findAll(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        List<Account> all = mapper.findAll();

        for (Account account : all) {
            System.out.println(account);
        }

        sqlSession.close();
    }



    @Test
    public void insert(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();


        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        mapper.insert(new Account("103","张三",6300,"2021-3-26","2021-3-26"));
        mapper.insert(new Account("105","元锦儿",9000,"2021-3-21","2021-3-22"));

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void update(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);

        int flag = mapper.updateByPrimaryKey(new Account("103", "李贫", 6300, "2021-03-26", "2021-03-27"));

        sqlSession.commit();
        if(flag>0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }

        sqlSession.close();

    }

    @Test
    public void selectByPrimaryKey(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        Account account = mapper.selectByPrimaryKey("102");
        System.out.println(account);
        sqlSession.close();
    }

    @Test
    public void deleteByPrimaryKey(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        int flag = mapper.deleteByPrimaryKey("101");
        if(flag>0){
            System.out.println("删除成功");
        }

        //事务提交
        sqlSession.commit();

        sqlSession.close();
    }
}
