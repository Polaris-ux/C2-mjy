package com.mjy.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author
 * @description
 * @create 2021-03-24 18:46
 */
public class Task3 {

    public static void main(String[] args) {
        Task3 task=new Task3();
        int[] arr=new int[]{1,3,-1,-3,5,3,6,7};
        int[] maxNums = task.findMaxInWindow(arr, 3);
        System.out.println(Arrays.toString(maxNums));
    }
    public int[] findMaxInWindow(int[] nums,int k){
        List<Integer> list=new ArrayList<>();
        int low=0;
        int high=k-1;
        while(low<high&&high<nums.length){
            int max=nums[low];
            for (int i = low; i <=high ; i++) {
                max=max>nums[i]? max:nums[i];
            }
            list.add(max);
            low++;
            high++;
        }
        int[] arr=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i]=list.get(i);
        }
        return arr;
    }
}
