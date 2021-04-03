package com.mjy.exercise;

import java.util.*;

/**
 * @author
 * @description
 * @create 2021-03-31 17:43
 */
public class Task3 {

    public static void main(String[] args) {
        Task3 task = new Task3();
        String[] arr = new String[]{"ttaaaa","pp","tpa","kpaqkt","tktpqq","aqppatp"};
        System.out.println(task.maxWords(arr));
    }


    public String maxWords(String[] words) {

        sort(words);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            list.add(words[i]);
        }

        for (String s : words) {
            list.remove(s);
            if (isComposedWord(list, s)) {
                return s;
            }
            list.add(s);
        }

        return "";

    }

    //先按照字符串长度降序排列，若长度相等，则按照字符串升序排列
    public void sort(String[] str) {
        Arrays.sort(str, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else {
                return Integer.compare(o2.length(), o1.length());
            }
        });
    }

    private boolean isComposedWord(List<String> set, String word) {
        if (word.length() == 0) {
            return true;
        }

        for (int i = 0; i < word.length(); i++) {
            if (set.contains(word.substring(0, i + 1))&&isComposedWord(set,word.substring(i + 1))) {
                return true;
            }

        }
        return false;
    }




}
