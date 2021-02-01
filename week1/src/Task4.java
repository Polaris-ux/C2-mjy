/**
 * @author mjy
 * @Description 定义一个圆的类
 * @create 2021-01-22-22:28
 */
public class Task4 {
    public static void main(String[] args) {
        Circle circle=new Circle(3);
        System.out.println("the area is "+circle.getArea());
        System.out.println("the perimeter is "+circle.getPerimeter());

    }
}
class Circle{
    private double radius;
    public Circle(){

    }
    public Circle(double radius){
        this.radius=radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea(){
        return radius*radius*Math.PI;
    }
    public double getPerimeter(){
        return 2*radius*Math.PI;
    }
}