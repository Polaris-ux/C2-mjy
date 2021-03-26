package com.mjy.exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author
 * @description
 * @create 2021-03-24 12:45
 */
public class Task0 {
    public static void main(String[] args) {
        Task0 task=new Task0();
        int[] arr=new int[]{2,4};
        int[] arr1=new int[]{1,2,3,4};
        int[] biggerNum = task.findBiggerNum1(arr, arr1);
        System.out.println(Arrays.toString(biggerNum));
    }

    public int[] findBiggerNum(int[] nums1,int[] nums2){
        int[] arr=new int[nums1.length];
        int j=0;
        for (int i = 0; i < nums1.length; i++) {
            //指向栈顶的指针
            int top=nums2.length-1;
            //查找的元素
            int num=nums1[i];
            while(nums2[top]!=nums1[i]){
                if(nums2[top]>nums1[i]){
                    num=nums2[top];
                }
                top--;
            }
            if(num!=nums1[i]){
                arr[j]=num;
            }else{
                arr[j]=-1;
            }
            j++;
        }
        return arr;
    }

    public int[] findBiggerNum1(int[] nums1,int[] nums2){
        Stack<Integer> stack=new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr=new int[nums1.length];
        //遍历数组，找到第一个比当前元素大的数并将其存入map中
        for (int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty()&&nums2[i]>stack.peek()){
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while(!stack.isEmpty()){
            map.put(stack.pop(),-1);
        }
        for (int i = 0; i < nums1.length; i++) {
            arr[i]=map.get(nums1[i]);
        }
        return arr;
    }
}
