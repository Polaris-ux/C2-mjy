import java.util.*;

/**
 * @author
 * @Description 获取到用户输入的一段字符串（可从键盘录入），例如：aaaabbbcccccdd。请编写程序
 * 获取其中无重复的字符组成一个新的字符串
 * @create 2021-02-09-23:38
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Set<Character> set=new HashSet<>();
        String str1="";
        System.out.println("请输入字符串");
        String str = scan.nextLine();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            set.add(c);
        }
        Iterator<Character> iterator = set.iterator();
        while(iterator.hasNext()){
            char c=iterator.next();
            str1+=c;
        }
        System.out.println(str1);
    }
}
