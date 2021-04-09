package com.mjy.exercise;

import java.util.*;

/**
 * @author
 * @description
 * @create 2021-04-07 18:09
 */
public class Task0 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list=new ArrayList<>();

        //获取随机数
        for (int i = 0; i < 1000; i++) {
            list.add(random.nextInt(20));
        }
        System.out.println(list);
        List<Integer> integers = TenMaxNum(list);
        System.out.println(integers);

    }

    public static List<Integer> TenMaxNum(List<Integer> list){
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> list2=new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            if(map.containsKey(list.get(i))){
                map.put(list.get(i),map.get(list.get(i))+1);
            }else{
                map.put(list.get(i),1);
            }
        }
        List<Map.Entry<Integer,Integer>> list1=new ArrayList<>(map.entrySet());

        //利用Collections对map排序
        Collections.sort(list1,new Comparator<Map.Entry<Integer,Integer>>(){


            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }
        });

        for (int i = 0; i < 10; i++) {
            list2.add(list1.get(i).getKey());
        }

        return list2;
    }
}
