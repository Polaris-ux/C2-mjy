import java.util.Scanner;

/**
 * @author
 * @Description 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * @create 2021-02-22-10:12
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        System.out.println(findComplicateStr(str));
    }
    public static int findComplicateStr(String str){
        //利用哈希数组对字符的出现次数计数
        int[] arr=new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            arr[c-'a']+=1;
        }
        //遍历
        for (int i = 0; i < str.length(); i++) {
            if(arr[str.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }

}
