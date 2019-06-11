package com.liebe;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileInputStream;
import java.io.InputStream;

public class MybatisCon {

    public static void main(String[] args) {
        try{
            String source = "src/sdf.xml";
            InputStream inputStream = new FileInputStream(source);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            sqlSession.selectOne("sdf");

            Object o;


            ApplicationContext appContext = new ClassPathXmlApplicationContext("cjj/models/beans.xml");
            appContext.getBean("person");
        }catch (Exception e){

        }

    }

}
