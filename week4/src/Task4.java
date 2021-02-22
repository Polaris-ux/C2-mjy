import java.util.*;

/**
 * @author
 * @Description 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没
 * 有，返回-1。
 * @create 2021-02-22-11:30
 */
public class Task4 {
    public static void main(String[] args) {
        int[] arr=new int[]{4,5};
        System.out.println(findPrimaryValue(arr));
    }
    public static int findPrimaryValue(int[] arr){
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            if(next.getValue()>arr.length/2){
                return next.getKey();
            }
        }
        return -1;
    }
}
