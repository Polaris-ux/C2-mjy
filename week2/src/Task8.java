/**
 * @author
 * @Description
 * @create 2021-02-01-10:54
 */
public class Task8 {
    public static void main(String[] args) {
        Star star = new Star();
        //多态体现
        Star sun = new Sun();
        Universe universe = new Sun();

        //向下转型
        Sun sun1 = (Sun) sun;
        star.shine();
        universe.doAnything();
        sun1.shine();

    }
}

interface Universe {
    void doAnything();
}

class Star {
    public void shine() {
        System.out.println("star:星星一闪一闪亮晶晶");
    }
}

class Sun extends Star implements Universe {

    @Override
    public void doAnything() {
        System.out.println("sun:太阳吸引着9大行星旋转");
    }

    @Override
    public void shine() {
        System.out.println("sun:光照八分钟到达地球");
    }
}
