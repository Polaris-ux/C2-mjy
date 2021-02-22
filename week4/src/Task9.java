/**
 * @author
 * @Description 创建两个线程 A 和 B，让他们交替打印 0 到 10 的所有整数，其中 A 线程打印偶数，B 线程
 * 打印奇数
 * @create 2021-02-22-16:51
 */
public class Task9 {

    public static void main(String[] args) {
        Thread thread=new Thread(new MyThread());
        Thread thread1=new Thread(new MyThread());
        thread.setName("线程A");
        thread.start();
        //保证线程A能够先执行
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.setName("线程B");
        thread1.start();
    }
}
class MyThread implements Runnable{
    public static int count=0;
    //锁
    public static Object lock=new Object();

    @Override
    public void run() {
        while (count<11) {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "打印：" + count);
                count++;
                //唤醒被wait的线程
                lock.notifyAll();
                if (count < 2) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}
