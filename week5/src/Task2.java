import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @description
 * @create2021-03-0923:17
 */
public class Task2 {
    public static void main(String[] args) {
        Task2 task=new Task2();
        int [] arr=new int[]{1,2,3};
        System.out.println(task.subsets(arr));

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        list.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int length=list.size();
            for (int j = 0; j <length ; j++) {
                //精华,将当前的list中的list1取出来,做为新list的一部分，并将nums[i]添加到该集合中
                List<Integer> list1=new ArrayList<>(list.get(j));
                list1.add(nums[i]);
                list.add(list1);
            }
        }
        return list;
    }
}
