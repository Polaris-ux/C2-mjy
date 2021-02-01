import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author
 * @Description
 * @create 2021-01-31-22:12
 */
public class Task2 {
    public static void main(String[] args) {
        Task2 task = new Task2();
        String str = "123hello67sjd90nsjd";
        List<Integer> num = task.findNum(str);
        System.out.println(num);
    }

    //利用正则表达式
    public List<Integer> findNum(String str) {
        List<Integer> list = new ArrayList<>();
        String regex = "[^0-9]+";
        Pattern pattern = Pattern.compile(regex);
        String[] split = pattern.split(str);
        for (int i = 0; i < split.length; i++) {
            if (split[i].length() != 0) {
                list.add(Integer.parseInt(split[i]));
            }
        }
        return list;
    }
}
