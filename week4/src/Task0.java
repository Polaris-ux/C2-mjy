import java.util.Scanner;

/**
 * @author
 * @Description 字符串匹配
 * @create 2021-02-22-9:57
 */
public class Task0 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入原字符串：");
        String str=scan.nextLine();
        System.out.println("请输入子字符串：");
        String subStr=scan.nextLine();
        System.out.println(matchStr(str, subStr));
    }
    public static int matchStr(String str,String subStr){
        boolean contains = str.contains(subStr);
        //判断子字符串是否存在
        if(contains){
            return str.indexOf(subStr);
        }
        return -1;
    }
}
