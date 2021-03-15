import DAO.Student;
import DAO.StudentDAO;
import Utils.JDBCUtils;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author
 * @description 查看表中的所有信息，遍历输出到控制台
 * @create 2021-03-15 11:44
 */
public class Task0 {
    public static void main(String[] args) {
        Connection conn = null;
        StudentDAO dao=new StudentDAO();

        try {
            conn= JDBCUtils.getConnection();
            //1、
            String sql4="insert into student values(?,?,?,?)";
            dao.update(conn, sql4, "s001", "老大", 20, "计算机学院");
            dao.update(conn, sql4, "s002", "老二", 19, "计算机学院");
            dao.update(conn, sql4, "s003", "老三", 18, "计算机学院");
            dao.update(conn, sql4, "s004", "老四", 17, "计算机学院");

            //2.查看表中的所有信息，遍历输出到控制台
            String sql="select sno,name,age,college from student";
            List<Student> students = dao.queryInstanceList(conn, sql);
            students.forEach(System.out::println);
            System.out.println("---------------------------------");
            //3.把sno为s004的记录删除
            String sql1="delete from student where sno=?";
            dao.update(conn,sql1,"s004");
            List<Student> students1 = dao.queryInstanceList(conn, sql);
            students1.forEach(System.out::println);

            System.out.println("------------------------------------");
            //4.查询sno为s003的记录
            String sql2="select * from student where sno=?";
            Student stu = dao.queryInstance(conn, sql2, "s003");
            System.out.println(stu);

            //5.把sno为s001的记录修改为('s001','老大',20,'通信学院')
            String sql3="update student set sno=?,name=?,age=?,college=? where sno=?";
            dao.update(conn,sql3,"s001","老大",20,"通信学院","s001");

            System.out.println("------------------------");
            List<Student> students2 = dao.queryInstanceList(conn, sql);
            students2.forEach(System.out::println);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {

            if(conn!=null){
                try {
                    DbUtils.close(conn);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
