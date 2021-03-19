import java.util.Arrays;

/**
 * @author
 * @description
 * @create 2021-03-17 23:50
 */
public class Task2 {

    public static void main(String[] args) {
        Task2 fun=new Task2();
        int[] arr=new int[]{5,1,6,7,2,1,9,5,6,8};
        fun.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    //冒泡
    public void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j =0; j < arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    //快排
    public void quickSort(int[] arr){
        subSort(arr,0,arr.length-1);

    }

    public void subSort(int[] arr,int start,int end){
        if(start<end){
            int base=arr[start];
            int low=start;
            int high=end+1;
            while(true){

                while(low<end&&arr[++low]<base);
                while(high>start&&arr[--high]>=base);

                if(low<high){
                    swap(arr,low,high);
                }else{
                    break;
                }
            }
            swap(arr,start,high);
            subSort(arr,start,high-1);
            subSort(arr,high+1,end);
        }
    }

    private void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }




    //合并排序
    public int[] mergeSort(int[] arr){
        if(arr.length<2){
            return arr;
        }
        int middle=arr.length/2;
        int[] left=Arrays.copyOfRange(arr,0,middle);
        int[] right=Arrays.copyOfRange(arr,middle,arr.length);
        return merge(mergeSort(left),mergeSort(right));
    }

    public int[] merge(int[] left,int[] right){
        int[] result=new int[left.length+right.length];
        int index=0;
        while(left.length>0&&right.length>0){
            if(left[0]<=right[0]){
                result[index++]=left[0];
                left=Arrays.copyOfRange(left,1,left.length);
            }else{
                result[index++]=right[0];
                right=Arrays.copyOfRange(right,1,right.length);
            }
        }
        for (int i = 0; i < left.length; i++) {
            result[index++]=left[i];
        }

        for (int i = 0; i < right.length; i++) {
            result[index++]=right[i];
        }
        return result;
    }


    //选择排序
    public void chooseSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int temp=arr[i];
            int j=0;
            for (j = i; j>0 ; j--) {
                if(temp<arr[j-1]){
                    arr[j]=arr[j-1];
                }else{
                    break;
                }
            }
            if(j!=i){
                arr[j]=temp;
            }

        }
    }

    //堆排序
    public void heapSort(int[] arr){
        //构建大根堆
        for (int i =arr.length/2-1; i>=0 ;i--) {
            adjustHeap(arr,i,arr.length);
        }

        //调整堆并交换堆顶元素和末尾元素
        for (int i =arr.length-1; i>0 ; i--) {
            swap(arr,0,i);
            adjustHeap(arr,0,i);
        }
    }

    public void adjustHeap(int[] arr,int i,int length){
        int temp=arr[i];
        for (int j =2*i+1; j <length;j=2*j+1) {
            if(j+1<length&&arr[j]<arr[j+1]){
                j=j+1;
            }
            if(temp<arr[j]){
                arr[i]=arr[j];
                i=j;
            }else{
                break;
            }
        }

        arr[i]=temp;
    }

}
