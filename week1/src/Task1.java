/**
 * @author mjy
 * @Description 第二题
 * @create 2021-01-22-21:21
 */
public class Task1 {
    public static void main(String[] args) {
        Task1 task = new Task1();
        int count = 0;
        for (int i = 100; i < 1000; i++) {
            if (task.isNarcissus(i)) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println("1000以内的水仙花数的个数为：" + count);
    }

    public boolean isNarcissus(int n) {
        int ge, shi, bai;
        bai = n / 100;
        shi = (n % 100) / 10;
        ge = n % 10;
        if ((Math.pow(bai, 3) + Math.pow(shi, 3) + Math.pow(ge, 3) == n)) {
            return true;
        } else {
            return false;
        }

    }
}
