import java.util.Scanner;

/**
 * @author
 * @Description 小数转分数
 * @create 2021-02-22-10:26
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        float num = scan.nextFloat();
        System.out.println(pointToGrade(num));
    }

    public static String pointToGrade(float num) {
        int count = 0;
        //Math.floor(num):返回比小于等于num的整数
        while (num != Math.floor(num)) {
            num *= 10;
            count++;
        }

        int num1 = (int) Math.pow(10, count);
        int maxDivide = findGcd((int) num, num1);
        return String.valueOf((int)num / maxDivide) + "/" + String.valueOf(num1 / maxDivide);
    }

    //找最大公约数
    public static int findGcd(int num1, int num2) {
        if (num2 == 0)
            return num1;
        return findGcd(num2, num1 % num2);
    }
}
