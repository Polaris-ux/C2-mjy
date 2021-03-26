package com.mjy.exercise;

/**
 * @author
 * @description
 * @create 2021-03-24 18:24
 */
public class Task2 {
    public static void main(String[] args) {
        Task2 task=new Task2();
        int[] arr=new int[]{1,2,3,2};
        System.out.println(task.sumOfUnique(arr));
    }

    public int sumOfUnique(int[] nums) {
        int[] arr=new int[101];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]%101]+=1;
        }
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==1){
                sum+=i;
            }
        }
        return sum;
    }
}
