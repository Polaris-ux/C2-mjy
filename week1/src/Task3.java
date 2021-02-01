import java.util.Arrays;

/**
 * @author mjy
 * @Description 将零移到数组的末尾
 * @create 2021-01-22-21:54
 */
public class Task3 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 4, 0, 6, 0, 9, 2,2};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
