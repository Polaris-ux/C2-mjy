package com.mjy.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author
 * @description
 * @create 2021-03-22 16:22
 */
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory=null;
    //配置文件
    private static String resource="mybatis-config.xml";
    private static InputStream inputStream=null;
    static{
        try {
            inputStream = Resources.getResourceAsStream(resource);
            //获取SqlSessionFactory
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 通过SqlSessionFactory获取SqlSession
     * @return
     */
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }


}
