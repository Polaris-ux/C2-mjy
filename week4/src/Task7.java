import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author
 * @Description 在电脑 c 盘的 csatest 目录下，创建一个名称为 demo.txt 的文件。然后将下列内容：
 * @create 2021-02-22-13:43
 */
public class Task7 {
    public static void main(String[] args) {
        String path="C:\\csatest\\demo.txt";
        System.out.println(loadFileNum(path));
    }
    public static int loadFileNum(String path){
        //缓冲流
        BufferedInputStream bi=null;
        int count=0;
        try {
            bi=new BufferedInputStream(new FileInputStream(path));
            //将文件中读进来的内容存到StringBuilder()中
            byte[] arr=new byte[1024];
            StringBuilder sbl=new StringBuilder();
            int len;
            while((len=bi.read(arr))!=-1){
                sbl.append(new String(arr,0,len));
            }
            String s = sbl.toString();
            //以csa作为分隔符,将字符串切分
            String[] csas = s.split("csa");
            for (int i = 0; i <csas.length ; i++) {
                if(!"".equals(csas[i])){
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bi!=null){
                try {
                    bi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return count;
        }
    }
}
