/**
 * @author
 * @Description
 * @create 2021-02-01-10:19
 */
public class Task6 {
    public static void main(String[] args) {
        Duck duck = new Duck("恶心呕吐", 3, "食物中毒");
        duck.showMsg();
        duck.showSymptom();
    }
}

//抽象类
abstract class Poultry {
    private String name;
    private String symptom;
    private int age;
    private String illness;

    public Poultry() {

    }

    public Poultry(String name, String symptom, int age, String illness) {
        this.name = name;
        this.symptom = symptom;
        this.age = age;
        this.illness = illness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public abstract void showSymptom();

    public void showMsg() {
        System.out.println("动物种类：" + name + ",年龄：" + age);
    }
}

class Duck extends Poultry {
    public Duck() {

    }

    public Duck(String symptom, int age, String illness) {
        super("鸭子", symptom, age, illness);
    }

    @Override
    public void showSymptom() {
        System.out.println("入院原因：" + this.getIllness());
        System.out.println("症状为：" + this.getSymptom());
    }
}
