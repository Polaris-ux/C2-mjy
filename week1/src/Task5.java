/**
 * @author
 * @Description
 * @create 2021-01-22-22:37
 */
public class Task5 {
    public static void main(String[] args) {
        Account acc = new Account("张三", 5600);
        System.out.println(acc.getBalance());
        acc.withdrawal(300);
        System.out.println(acc.getBalance());

    }
}

class Account {
    private String name;
    private double balance;

    public Account() {

    }

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdrawal(double money) {
        if (money > balance) {
            System.out.println("余额不足！！！，取款失败");
        } else {
            balance = balance - money;
        }
    }
}