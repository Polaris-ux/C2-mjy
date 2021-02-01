/**
 * @author
 * @Description
 * @create 2021-02-01-10:36
 */
public class Task7 {
    public static void main(String[] args) {
        C c = new C();
        c.showA();
        c.showB();
        c.showC();
    }
}

abstract class A {
    private int numa = 10;

    public abstract void showA();

    public int getNuma() {
        return numa;
    }

    public void setNuma(int numa) {
        this.numa = numa;
    }
}

abstract class B extends A {

    private int numb = 20;

    public abstract void showB();

    public int getNumb() {
        return numb;
    }

    public void setNumb(int numb) {
        this.numb = numb;
    }
}

class C extends B {
    private int numc = 30;

    @Override
    public void showA() {
        System.out.println("A类中的numa:" + super.getNuma());
    }

    @Override
    public void showB() {
        System.out.println("B类中的numb:" + super.getNumb());
    }

    public void showC() {
        System.out.println("C类中的numc:" + numc);
    }

    public int getNumc() {
        return numc;
    }

    public void setNumc(int numc) {
        this.numc = numc;
    }
}
