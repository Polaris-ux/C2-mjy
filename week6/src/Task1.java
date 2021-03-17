import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @description
 * @create 2021-03-17 17:22
 */
public class Task1 {
    public static void main(String[] args) {
        Task1 task=new Task1();
        int[][] arr=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> integers = task.clockwiseMatrix(arr);
        System.out.println(integers);
    }


    //难点：边界判断
    public List<Integer> clockwiseMatrix(int[][] matrix){
        int rowLength=matrix.length;
        int colLength=matrix[0].length;
        int m=0,n=0;
        List<Integer> list=new ArrayList<>();
        while(rowLength>0&&colLength>0){

            if(rowLength==1){
                for (int i = 0; i < colLength; i++) {
                    list.add(matrix[m][n++]);
                }
                return list;
            }else if(colLength==1){
                for (int i = 0; i < rowLength; i++) {
                    list.add(matrix[m++][n]);
                }

                return list;
            }
            //向右
            for (int i = 0; i < colLength - 1; i++) {
                list.add(matrix[m][n++]);
            }

            //向下
            for (int i = 0; i < rowLength-1; i++) {
                list.add(matrix[m++][n]);
            }

            //向左
            for (int i = 0; i < colLength - 1; i++) {
                list.add(matrix[m][n--]);
            }
            //向上
            for (int i = 0; i < rowLength - 1; i++) {
                list.add(matrix[m--][n]);
            }

            m++;
            n++;
            rowLength-=2;
            colLength-=2;
        }
        return list;
    }
}
