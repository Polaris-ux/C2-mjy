import java.util.Arrays;
import java.util.Scanner;

/**
 * @author mjy
 * @Description 反转字符串
 * @create 2021-01-22-21:41
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Task2 task = new Task2();
        System.out.println("请输入需要反转的字符串：");
        String str = scan.next();
        String reverseStr = task.reverseString(str);
        System.out.println(reverseStr);
    }

    public String reverseString(String str) {
        char[] chars = str.toCharArray();
        char temp;
        for (int i = 0; i < chars.length / 2; i++) {
            temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        String reverStr = String.valueOf(chars);
        return reverStr;
    }
}
