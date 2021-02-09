import java.util.*;

/**
 * @author
 * @Description 输入一串由英文单词组成的字符串，现在需要统计出每个英文字母出现的频数。
 * @create 2021-02-09-23:58
 */
public class Task3 {
    public static void main(String[] args) {
        Map<Character,Integer> map=new HashMap<>();
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入字符串：");
        String str = scan.nextLine();
        char[] arr=str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                //更新关键字的数量
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        //获取set的迭代器
        Iterator<Map.Entry<Character,Integer>> iterator=entries.iterator();
        //遍历
        while(iterator.hasNext()){
            Map.Entry<Character,Integer> entry=iterator.next();
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
    }
}
