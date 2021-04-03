package com.mjy.exercise;

/**
 * @author
 * @description
 * @create 2021-03-31 17:28
 */
public class Task1 {
    public static void main(String[] args) {
        Task1 task=new Task1();
        boolean flag = task.isValidDelete("abcda");
        System.out.println(flag);

    }

    private boolean isValid(String str,int left,int right){
        while(left<right){
            if(str.charAt(left)!=str.charAt(right) ){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public boolean isValidDelete(String str){
        int left=0;
        int right=str.length()-1;
        while(left<right){
            //当字符不匹配时，判断它的子串是否为回文字符串，若为回文字符串则返回true，反之返回false;
            if(str.charAt(left)!=str.charAt(right)){
                return isValid(str,left,right-1)||isValid(str,left+1,right);
            }
            left++;
            right--;
        }
        return true;
    }
}
