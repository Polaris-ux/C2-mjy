import java.util.*;

/**
 * @author
 * @Description 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字
 * 符串。
 * @create 2021-02-22-12:49
 */
public class Task6 {
    public static void main(String[] args) {
        String[] arr=new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(strArray(arr));
    }

    public static List<List<String>> strArray(String[] arr){
        HashMap<String,List<String>> map=new HashMap<>();
        List<List<String>> list=new ArrayList<>();
        //字符串数组排序
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
            char[] chars = arr[i].toCharArray();
            //字符串排序
            Arrays.sort(chars);
            //以map为容器
            if(map.containsKey(Arrays.toString(chars))){
                List<String> list1 = map.get(Arrays.toString(chars));
                List<String> list2=new ArrayList<>();
                list2.addAll(list1);
                list2.add(arr[i]);
                map.put(Arrays.toString(chars),list2);
            }else{
                map.put(Arrays.toString(chars),Arrays.asList(arr[i]));
            }
        }
        Collection<List<String>> values = map.values();
        for (List<String> value : values) {
            list.add(value);
        }
        return list;
    }
}
