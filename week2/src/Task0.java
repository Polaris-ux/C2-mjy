import java.util.Arrays;

/**
 * @author
 * @Description
 * @create 2021-01-31-20:36
 */
public class Task0 {
    public static void main(String[] args) {
        Task0 task = new Task0();
        int[][] arr = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        int[][] arr1 = task.rotateMatrix(arr);
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(Arrays.toString(arr1[i]));
        }

    }

    //旋转矩阵
    public int[][] rotateMatrix(int[][] arr) {
        int n = arr.length;
        int[][] arr1 = new int[n][n];
        int k = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                arr1[j][k] = arr[i][j];
            }
            k++;
        }
        return arr1;
    }
}
