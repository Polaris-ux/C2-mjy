import java.util.Scanner;

/**
 * @author
 * @Description
 * @create 2021-01-22-20:48
 */
public class task0 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入体重(Kg)：");
        double weight=scan.nextDouble();
        while(weight<=0){
            System.out.println("您输入的体重有误，请重新输入：");
            weight=scan.nextDouble();
        }
        System.out.println("请输入身高(m)：");
        double height=scan.nextDouble();
        while(height<=0){
            System.out.println("您输入的身高有误，请重新输入：");
            height=scan.nextDouble();
        }
        double BMI=weight/(height*height);
        if(BMI<18.5){
            System.out.println("过轻");
        }else if(BMI>=18.5&&BMI<25){
            System.out.println("正常");
        }else if(BMI>=25&&BMI<28){
            System.out.println("过重");
        }else if(BMI>=28&&BMI<32){
            System.out.println("肥胖");
        }else{
            System.out.println("非常肥胖");
        }

    }
}
