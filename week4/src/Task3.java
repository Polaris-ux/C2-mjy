import java.util.Arrays;

/**
 * @author
 * @Description 给定一个整数数组，找出该数组中第 k 小的数
 * @create 2021-02-22-11:02
 */
public class Task3 {
    public static void main(String[] args) {
        int[] arr=new int[]{2,5,3,72,8,3,6};
        System.out.println(findRankNum(arr, 5));

    }
    public static int findRankNum(int[] arr,int k){
        if(k>arr.length)
            return -1;
        Arrays.sort(arr);
        return arr[k-1];
    }

    //熟悉一下快排
    public static void sort(int[] arr,int start,int end){
        if(end>start){
            int low=start;
            int high=end+1;
            int base=arr[start];
            while(true){
                while(low<end&&arr[++low]<base);
                while(start<high&&arr[--high]>=base);
                if(low<high){
                    swap(arr,low,high);
                }else{
                    break;
                }
            }
            swap(arr,start,high);
            sort(arr,start,high-1);
            sort(arr,high+1,end);
        }
    }
    public static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    public static void quickSort(int[] arr){
        sort(arr,0,arr.length-1);
    }
}
