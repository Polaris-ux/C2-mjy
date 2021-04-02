package com.mjy.exercise;

/**
 * @author
 * @description leetcode 二进制数转小数
 * @create 2021-03-31 17:17
 */
public class Task0 {
    public static void main(String[] args) {
        Task0 task=new Task0();
        System.out.println(task.binaryToStr(0.625));
    }

    public String binaryToStr(double num){
        StringBuilder sbl=new StringBuilder();
        while(num!=0){
            double temp=num*2;
            if(temp>=1){
                num=temp-1;
                sbl.append(1);
            }else{
                num=temp;
                sbl.append(0);
            }

            if(sbl.length()>32){
                return "ERROR";
            }
        }
        return "0."+sbl.toString();
    }
}
