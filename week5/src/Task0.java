/**
 * @author
 * @description
 * @create2021-03-0823:55
 */
public class Task0 {
    public static void main(String[] args) {
        Task0 task=new Task0();
        System.out.println(task.reverse1(-1243545));
    }

    //较笨的办法
    public int reverse(int x) {
        String s = String.valueOf(x);
        String str="";
        int flag=0;
        if(x<0){
            str+="-";
            flag=1;
        }
        for (int i=s.length()-1;i>=flag; i--) {
            str+=s.charAt(i);
        }
        Long aLong = Long.valueOf(str);
        if(aLong>Math.pow(2,31)-1||aLong<-Math.pow(2,31)){
            return 0;
        }
        return Integer.valueOf(str);
    }
    //网上较快的办法
    public int reverse1(int x){
        int temp=0;
        int result=0;
        while(x!=0){
            temp=result;
            result=result*10+x%10;
            x=x/10;
            if(result/10!=temp) return 0;
        }
        return result;
    }
}
