import com.mjy.pojo.Account;
import com.mjy.service.AccountServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author
 * @description
 * @create 2021-03-26 19:55
 */
public class AccountServiceTest {
    @Test
    public void findAll(){
        AccountServiceImpl accountService = new AccountServiceImpl();
        List<Account> all = accountService.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void insert(){
        AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.insert(new Account("109","乌启豪",3700,"2021-01-13","2021-02-15"));
    }

    @Test
    public void deleteByPrimaryKey(){
        AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.deleteByPrimaryKey("109");
    }

    @Test
    public void selectByPrimaryKey(){
        AccountServiceImpl accountService = new AccountServiceImpl();
        Account account = accountService.selectByPrimaryKey("102");
        System.out.println(account);
    }

    @Test
    public void updateByPrimaryKey(){
        AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.updateByPrimaryKey(new Account("102","高秀",7400,"2021-03-22","2021-03-24"));
    }

    @Test
    public void tranfer(){
        AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.tranfer("102","103",500);
    }
}
