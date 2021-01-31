/**
 * @author
 * @Description
 * @create 2021-01-31-23:12
 */
public class Task4 {
    public static void main(String[] args) {
        Monkey monkey = new Monkey("hello");
        People people = new People();
        monkey.speak();
        people.speak();
        people.think();
    }
}

class Monkey {
    private String s;

    public Monkey() {

    }

    public Monkey(String s) {
        this.s = s;
    }

    public void speak() {
        System.out.println("咿咿呀呀......");
    }
}

class People extends Monkey {
    @Override
    public void speak() {
        System.out.println("小样的，不错嘛！会说话了");
    }

    public void think() {
        System.out.println("别说话！认真思考！");
    }
}