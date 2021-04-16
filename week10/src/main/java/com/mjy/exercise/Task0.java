package com.mjy.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @description 自己的理解：一个用户可以使用多个修改券
 * @create 2021-04-15 16:42
 */
public class Task0 {
    public static void main(String[] args) {
        int[] arr=new int[]{13,9,17,29,13};

        System.out.println(sendQuan(arr));

    }

    public static boolean isSquare(int num){
        int low=1;
        int high=num;
        while(low<high){
            int mid=(low+high)/2;
            if(num==mid*mid){
                return true;
            }else if(mid*mid>num){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return false;
    }

    public static int sendQuan(int[] arr){
        int n=0;
        if(arr.length%2==0){
            n=arr.length/2;
        }else{
            n=arr.length/2+1;
        }
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        int j=0;
        int count=0;
        while(list.size()>arr.length-n){
            for (int i = 0; i < arr.length; i++) {
                if(arr[i]!=-1&&(isSquare(arr[i]-j)||isSquare(arr[i]+j))){
                    list.remove(new Integer(arr[i]));
                    count+=j;
                    arr[i]=-1;
                }
                if(list.size()<=arr.length-n) break;
            }
            j++;
        }
        return count;
    }
}
