package com.mjy.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @description
 * @create 2021-04-07 18:56
 */
public class Task1 {

    public static void main(String[] args) {
        Task1 task=new Task1();
        System.out.println(task.lastRemaining(10, 17));
    }

    //自己推的暴力解法，leetcode超时了
    public int lastRemaining(int n, int m){
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int i=0,j=0;
        while(list.size()>1){
            j++;
            if(j==m){
                list.remove(i);
                j=0;
            }else{
                i++;
            }
            if(i>=list.size()){
                i=0;
            }

        }
        return list.get(0);
    }


    public int lastRemaining1(int n, int m){
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx=0;
        while(n>1){
            idx=(idx+m-1)%n;
            list.remove(idx);
            n--;
        }

        return list.get(0);
    }
}
