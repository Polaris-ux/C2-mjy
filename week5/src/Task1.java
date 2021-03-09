/**
 * @author
 * @description
 * @create2021-03-09 22:30
 */
public class Task1 {
    public static void main(String[] args) {
        Task1 task=new Task1();
        System.out.println(task.climbStairs(5));
    }
    //思路：爬到第n阶楼梯的时候可能是一步也可能是两步。f(n)=f(n-1)+f(n-2);
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int n1=1;
        int n2=2;
        for(int i=3;i<=n;i++){
            int temp=n1+n2;
            n1=n2;
            n2=temp;
        }
        return n2;
    }
}
