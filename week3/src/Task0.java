import java.util.*;

/**
 * @author
 * @Description 三数之和：给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a， b，c ，
 *               使得 a + b + c =target。请你找出所有满足条件且不重复的三元组。
 * @create 2021-02-09-21:49
 */
public class Task0 {
    public static void main(String[] args) {
        //去leetcode冲了一下三数之和，超时了（太菜了
        Task0 task=new Task0();
        int[] nums=new int[]{-1,0,1,2,-1,-4};
        int target=0;
        List<List<Integer>> lists = task.threeSum(nums, target);
        System.out.println(lists);
    }
    public List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> list=new ArrayList<>();
        //用set装，避免重复
        Set<List<Integer>> set=new HashSet<>();
        //先将数组排序
        Arrays.sort(nums);
        //判断，提高效率
        if(nums.length<3||(nums[0]+nums[1]+nums[2])>target){
            return new ArrayList<List<Integer>>();
        }
        //枚举，感觉可以改进，但没想出来
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if((nums[i]+nums[j]+nums[k])>target){
                        break;
                    }else if((nums[i]+nums[j]+nums[k])==target){
                        ArrayList<Integer> list1 = new ArrayList<>();
                        list1.add(nums[i]);
                        list1.add(nums[j]);
                        list1.add(nums[k]);
                        set.add(list1);
                    }
                }
            }
        }
        list.addAll(set);
        return list;
    }
}
