package com.mjy.exercise;

/**
 * @author
 * @description 给定一个二进制数组，计算其中最大连续 1 的个数。
 * @create 2021-03-24 18:59
 */
public class Task4 {
    public static void main(String[] args) {
        Task4 task=new Task4();
        int[] arr=new int[]{1,1,0,1,1,1};
        System.out.println(task.continueNumLength1(arr));
    }

    public int continueNumLength(int[] nums) {
        for (int i = nums.length; i > 0; i--) {
            int low = 0;
            int high = i - 1;
            while (high < nums.length) {
                int flag = 1;
                for (int j = low; j <= high; j++) {
                    if (nums[j] != 1) {
                        flag = 0;
                        break;
                    }
                }
                if (flag == 1) {
                    return i;
                }
                low++;
                high++;
            }
        }
        return 0;
    }

    public int continueNumLength1(int[] nums) {
        int pre=0;
        int curr=0;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]==0){
                pre=pre>curr? pre:curr;
                curr=0;
            }else{
                curr+=nums[i];
            }
        }

        return pre>curr? pre:curr;
    }
}
