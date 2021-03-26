package com.mjy.exercise;

import java.util.Stack;

/**
 * @author
 * @description
 * @create 2021-03-24 13:05
 */
public class Task1 {
    public static void main(String[] args) {
        Task1 task=new Task1();

        int[] arr=new int[]{1,2,3,4,5};
        int[] arr1=new int[]{4,5,2,3,1};
        System.out.println(task.pushAndPop(arr, arr1));
    }


    public boolean pushAndPop(int[] push,int[] pop){
        Stack<Integer> stack=new Stack<>();
        int indexPop=0;
        for (int i = 0; i < push.length; i++) {
            stack.push(push[i]);
            while(!stack.isEmpty()&&stack.peek()==pop[indexPop]){
                stack.pop();
                indexPop++;
            }
        }
        return stack.isEmpty();
    }
}
