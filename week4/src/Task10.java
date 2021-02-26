/**
 * @author
 * @Description
 * @create 2021-02-22-22:26
 */
public class Task10 {
    public static void main(String[] args) {
        Message msg=new Message();
        new Thread(new Producer(msg)).start();
        new Thread(new Consumer(msg)).start();
    }

}
class Message{
    //信息的标题
    private String title;
    //保存信息的内容
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

class Producer implements Runnable{
    private Message msg=null;
    public Producer(Message msg){
        this.msg=msg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if(i%2==0){
                msg.setTitle("李兴华");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                msg.setContent("java讲师");
            }else{
                msg.setTitle("mldn");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                msg.setContent("www.mldnjava.cn");
            }
        }
    }
}

class Consumer implements Runnable{
    private Message msg=null;
    public Consumer(Message msg){
        this.msg=msg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(msg.getTitle()+"--->"+msg.getContent());
        }
    }
}
