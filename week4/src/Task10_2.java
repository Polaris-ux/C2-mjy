/**
 * @author
 * @Description
 * @create 2021-02-22-23:27
 */
public class Task10_2 {
    public static void main(String[] args) {
        Message2 msg=new Message2();
        new Thread(new Producer2(msg)).start();
        new Thread(new Consumer2(msg)).start();
    }
}
class Message2{
    private String title;
    private String content;
    private boolean flag=true;

    public synchronized void setField(String title,String content){
        if(flag==false){//已经生产过了，不能生产
            try {
                wait();//等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.title=title;
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.content=content;
        flag=false;
        notify();
    }

    public synchronized void getField(){
        if(flag==true){//可以生产，不能取
            try {
                wait();//等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(title+"-->"+content);
        flag=true;
        notify();
    }
}

class Producer2 implements Runnable{
    private Message2 msg=null;
    public Producer2(Message2 msg){
        this.msg=msg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if(i%2==0){
                msg.setField("李兴华","java讲师");
            }else{
                msg.setField("mldn","www.mldnjava.cn");
            }
        }
    }
}

class Consumer2 implements Runnable{
    private Message2 msg=null;
    public Consumer2(Message2 msg){
        this.msg=msg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            msg.getField();
        }
    }
}
