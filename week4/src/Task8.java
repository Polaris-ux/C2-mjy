import java.io.*;

/**
 * @author
 * @Description 将之前 c/csatest/demo.txt 中的内容复制到 c/csatest2/demo2.txt 文件中
 * @create 2021-02-22-16:34
 */
public class Task8 {
    public static void main(String[] args) {
        File file=new File("C:\\csatest2");
        if(!file.exists()){
            file.mkdirs();
        }
        String path="C:\\csatest\\demo.txt";
        String path1="C:\\csatest2\\demo2.txt";
        copyFileSelf(path,path1);

    }
    public static void copyFileSelf(String path,String path1){
        FileInputStream fis=null;
        FileOutputStream fos=null;
        try {
            //造流
            fis=new FileInputStream(path);
            fos=new FileOutputStream(path1);

            //文件的读取和写入操作
            byte[] arr=new byte[24];
            int len;
            while((len=fis.read(arr))!=-1){
                fos.write(arr,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
