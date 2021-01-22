/**
 * @author
 * @Description
 * @create 2021-01-22-23:22
 */
public class Task7 {
    public static void main(String[] args) {
        Rabbit rabbit=new Rabbit();
        Tiger tiger=new Tiger();
        rabbit.eat();
        tiger.eat();
        rabbit.sleep();
    }
}
class Animal{
    private double height;
    private double weight;
    public Animal(){

    }
    public Animal(double height,double weight){
        this.height=height;
        this.weight=weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void eat(){
        System.out.println("动物要吃东西，干饭人干饭魂");
    };
    public void sleep(){
        System.out.println("动物需要睡觉~");
    };
}
class Rabbit extends Animal{
    public Rabbit(){
        super();
    }

    @Override
    public void eat() {
        System.out.println("兔子爱吃胡萝卜");
    }
}
class Tiger extends Animal{
    public Tiger(){
        super();
    }

    @Override
    public void eat() {
        System.out.println("老虎爱吃肉");
    }
}

