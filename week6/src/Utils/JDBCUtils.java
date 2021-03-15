package Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author
 * @description 操作数据库的工具类
 * @create 2021-03-15 10:51
 */
public class JDBCUtils {

    /**
     * 从Druid数据库连接池中获取链接
     *
     */
    private static DataSource source=null;
    static{
        InputStream is=null;
        Properties pro=new Properties();
        try {
            is= ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            source=new DruidDataSourceFactory().createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Connection getConnection() throws SQLException {

        Connection connection=source.getConnection();

        return connection;

    }
}
