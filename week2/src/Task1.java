/**
 * @author
 * @Description 字符串最大前缀
 * @create 2021-01-31-20:54
 */
public class Task1 {
    public static void main(String[] args) {
        Task1 task = new Task1();
        String[] str = new String[]{"cag", "cacecar", "car"};
        System.out.println(task.findMaxPrefix(str));

    }

    public String findMaxPrefix(String[] str) {
        if (str == null || str.length == 0) {
            return "";
        }
        String str1 = str[0];
        for (int i = 1; i < str.length; i++) {
            str1 = maxString(str1, str[i]);
            if (str1.length() == 0) break;
        }
        return str1;
    }

    //找到两个字符串中最大的前缀
    public String maxString(String str, String str1) {
        String str2 = str.length() < str1.length() ? str : str1;
        int index = 0;
        while (index < str2.length()) {
            if (str.charAt(index) != str1.charAt(index)) {
                break;
            }
            index++;
        }
        return str2.substring(0, index);
    }

    //理解错题意，写成找所有字符串的最大公共部分了
    public String findMaxPrefix1(String[] str) {
        int length = str[0].length();
        String str1 = str[0], str2 = "";
        int flag = 1, flag2 = 0;
        //找到长度最短的字符串
        for (int i = 1; i < str.length; i++) {
            if (length > str[i].length()) {
                length = str[i].length();
                str1 = str[i];
            }
        }
        for (int i = length; i > 0; i--) {
            for (int j = 0; j < length - i + 1; j++) {
                flag = 1;
                if (j + i > length) {
                    str2 = str1.substring(j);
                } else {
                    str2 = str1.substring(j, j + i);
                }
                for (int k = 0; k < str.length; k++) {
                    if (!str[k].contains(str2)) {
                        flag = 0;
                        break;
                    }
                }
                if (flag == 1) {
                    flag2 = 1;
                    break;
                }
            }
            if (flag2 == 1) {
                break;
            }
        }
        if (flag == 0) {

            return "";
        } else {
            return str2;
        }

    }
}
