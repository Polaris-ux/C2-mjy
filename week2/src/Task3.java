import java.util.Scanner;

/**
 * @author
 * @Description
 * @create 2021-01-31-22:50
 */
public class Task3 {
    public static void main(String[] args) {
        Game game = new Game();
        game.guess();
    }
}

//使用了一个随机数
class Game {
    private static final int v = (int) Math.random() * 90 + 10;

    public Game() {

    }

    public void guess() {
        Scanner scan = new Scanner(System.in);
        System.out.println("欢迎来到猜数字小游戏！！^_^");
        System.out.println("偷偷告诉你数字的范围为0-100哦");
        System.out.println("请输入您猜的数字(-1退出)：");
        int guess = scan.nextInt();
        while (guess != -1) {
            if (guess > v) {
                System.out.println("猜大了哦，再试一次吧！");
            } else if (guess < v) {
                System.out.println("猜小了哦，再试一次吧！");
            } else {
                System.out.println("恭喜你，猜对了！！^-^");
                break;
            }
            guess = scan.nextInt();
        }

    }

}
