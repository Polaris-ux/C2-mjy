/**
 * @author
 * @Description
 * @create 2021-02-22-23:07
 */
public class Task10_1 {
    public static void main(String[] args) {
        Message1 msg=new Message1();
        new Thread(new Producer1(msg)).start();
        new Thread(new Consumer1(msg)).start();
    }
}

class Message1{
    private String title;
    private String content;
    public synchronized void setField(String title,String content){
        this.title=title;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.content=content;
    }
    public synchronized void getField(){
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(title+"--->"+content);
    }
}

class Producer1 implements Runnable{
    private Message1 msg=null;
    public Producer1(Message1 msg){
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

class Consumer1 implements Runnable{
    private Message1 msg=null;
    public Consumer1(Message1 msg){
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
