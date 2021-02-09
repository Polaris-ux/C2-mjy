/**
 * @author
 * @Description 自定义一个异常类，然后在发生异常时能调用到你自定义的异常类
 * @create 2021-02-10-0:11
 */
public class Task4 {
    public static void main(String[] args) {
        try {
            int result=4/0;
        } catch (Exception e) {
            throw new MyException();
        }
    }
}

class MyException extends RuntimeException{
    private boolean flag;
    private int errorId;

    static final long serialVersionUID = 7818146090155L;
    public MyException(){
        super();
    }
    public MyException(boolean flag,int errorId,String massage){
        super(massage);
        this.flag=flag;
        this.errorId=errorId;
    }

    @Override
    public String toString() {
        return flag+","+errorId+","+super.toString();
    }
}