import java.util.Scanner;

/**
 * @author mjy
 * @Description 实现复数的运算
 * @create 2021-01-22-22:47
 */
public class Task6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入第一个复数的实部和虚部");
        int real = scan.nextInt();
        int ima = scan.nextInt();
        System.out.println("请输入第二个复数的实部和虚部");
        int real1 = scan.nextInt();
        int ima1 = scan.nextInt();
        Plural p1 = new Plural(real, ima);
        Plural p2 = new Plural(real1, ima1);
        Plural p3 = p1.add(p2);
        System.out.println(p3);
        p3 = p1.reduce(p2);
        System.out.println(p3);
        p3 = p1.mutiply(p2);
        System.out.println(p3);


    }
}

class Plural {
    private int realComponent;
    private int imaComponent;

    public Plural() {

    }

    public Plural(int realComponent, int imaComponent) {
        this.realComponent = realComponent;
        this.imaComponent = imaComponent;
    }

    public int getRealComponent() {
        return realComponent;
    }

    public void setRealComponent(int realComponent) {
        this.realComponent = realComponent;
    }

    public int getImaComponent() {
        return imaComponent;
    }

    public void setImaComponent(int imaComponent) {
        this.imaComponent = imaComponent;
    }

    public Plural add(Plural p) {
        int newImaComponent = this.imaComponent + p.getImaComponent();
        int newRealComponent = this.realComponent + p.getRealComponent();
        return new Plural(newRealComponent, newImaComponent);
    }

    public Plural reduce(Plural p) {
        int newImaComponent = this.imaComponent - p.getImaComponent();
        int newRealComponent = this.realComponent - p.getRealComponent();
        return new Plural(newRealComponent, newImaComponent);
    }

    public Plural mutiply(Plural p) {
        int newImaComponent = this.imaComponent * p.getRealComponent() + this.realComponent * p.getImaComponent();
        int newRealComponent = this.realComponent * p.getRealComponent() - this.imaComponent * p.getImaComponent();
        return new Plural(newRealComponent, newImaComponent);
    }

    @Override
    public String toString() {
        if (imaComponent == 1) {
            return realComponent + "+" + "i";
        } else if (realComponent == 0) {
            return imaComponent + "i";
        } else {
            return realComponent + "+" + imaComponent + "i";
        }
    }
}
