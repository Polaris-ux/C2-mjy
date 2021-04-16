package com.mjy.exercise;

import java.util.*;

/**
 * @author
 * @description
 * @create 2021-04-15 18:02
 */
public class Task1 {
    public static void main(String[] args) {
        String str="1234";
        System.out.println(subStrNum1(str));
    }
    
    public static List<String> subStrNum1(String str){
        List<String> list=new ArrayList<>();
        for (int i = 1; i <=str.length() ; i++) {

            for (int j = 0; j <=str.length()-i; j++) {
                String substring = str.substring(j, j + i);
                if(!list.contains(substring)){
                    list.add(substring);
                }
            }
        }
        return list;
    }
}
