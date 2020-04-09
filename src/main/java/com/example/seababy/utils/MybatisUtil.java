package com.example.seababy.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
  //获取SqlSession
  public static SqlSession GetSqlSession(){
    // 指定全局配置文件
    String resource = "mybatis-config.xml";
    // 读取配置文件
    InputStream inputStream = null;
    try {
      inputStream = Resources.getResourceAsStream(resource);
    } catch (IOException e) {
      e.printStackTrace();
    }
    // 构建sqlSessionFactory
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    // 获取sqlSession
    SqlSession sqlSession = sqlSessionFactory.openSession();
    return sqlSession;
  }
}
