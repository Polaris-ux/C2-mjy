/**
 * @author
 * @Description
 * @create 2021-01-31-23:23
 */
public class Task5 {
    public static void main(String[] args) {
        Car car = new Car(5);
        Car car1 = new Car(7);
        Truck truck = new Truck(2, 4000);
        Truck truck1 = new Truck(1, 6000);
        System.out.println("车轮的个数：" + car.getWheels() + "\t车重：" + car.getWeight());
        car.isOverLoadTips();

        System.out.println("车轮的个数：" + car1.getWheels() + "\t车重：" + car1.getWeight());
        car1.isOverLoadTips();

        System.out.println("车轮的个数：" + truck.getWheels() + "\t车重：" + truck.getWeight());
        truck.isOverLoad();

        System.out.println("车轮的个数：" + truck1.getWheels() + "\t车重：" + truck1.getWeight());
        truck1.isOverLoad();

    }
}

class Vehicle {
    private int wheels;
    private double weight;

    public Vehicle() {

    }

    public Vehicle(int wheels, double weight) {
        this.wheels = wheels;
        this.weight = weight;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

class Car extends Vehicle {
    private int loader;
    private static final int totalLoader = 5;

    public Car() {

    }

    public Car(int loader) {
        super(4, 1150);
        this.loader = loader;
    }

    public int getLoader() {
        return loader;
    }

    public void setLoader(int loader) {
        this.loader = loader;
    }

    public void isOverLoadTips() {
        if (loader > totalLoader) {
            System.out.println("这是一辆小车，能载" + totalLoader + "人，实载" + loader + "人，您已超员！！！");
        } else {
            System.out.println("这是一辆小车，能载" + totalLoader + "人，实载" + loader + "人");
        }
    }
}

class Truck extends Vehicle {
    private int loader;
    private double payLoad;
    private static final double totalPayLoad = 5000;
    private static final int totalLoader = 3;

    public Truck() {

    }

    public Truck(int loader, double payLoad) {
        super(6, 15000);
        this.loader = loader;
        this.payLoad = payLoad;
    }

    public int getLoader() {
        return loader;
    }

    public void setLoader(int loader) {
        this.loader = loader;
    }

    public double getPayLoad() {
        return payLoad;
    }

    public void setPayLoad(double payLoad) {
        this.payLoad = payLoad;
    }

    public void isOverLoad() {
        if (loader > totalLoader) {
            System.out.println("这是一辆卡车，能载" + totalLoader + "人，实载" + loader + "人，您已超员！！！");
        } else {
            System.out.println("这是一辆卡车，能载" + totalLoader + "人，实载" + loader + "人");
        }

        if (payLoad > totalPayLoad) {
            System.out.println("这是一辆卡车，核载" + totalPayLoad + "，您已装载" + payLoad + "Kg,你超载了!!");
        } else {
            System.out.println("这是一辆卡车，核载" + totalPayLoad + "，您已装载" + payLoad + "Kg");
        }
    }
}
