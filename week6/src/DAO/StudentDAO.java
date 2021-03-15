package DAO;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @description
 * @create 2021-03-15 15:15
 */
public class StudentDAO {

    private static QueryRunner runner=new QueryRunner();

    /**
     * 修改student表的记录
     * @param conn
     * @param sql
     * @param params
     * @return
     */
    public int update(Connection conn,String sql,Object...params){
        try {
            return runner.update(conn,sql,params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    /**
     * 查询单个学生的记录
     * @param conn
     * @param sql
     * @param params
     * @return
     */

    public Student queryInstance(Connection conn,String sql,Object...params){
        BeanHandler<Student> beanHand=new BeanHandler<>(Student.class);
        try {
            Student query = runner.query(conn, sql, beanHand, params);
            return query;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Student> queryInstanceList(Connection conn,String sql,Object...params){
        BeanListHandler<Student> list=new BeanListHandler<>(Student.class);

        try {
            List<Student> query = runner.query(conn,sql,list,params);
            return query;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return new ArrayList<>();
    }
}
