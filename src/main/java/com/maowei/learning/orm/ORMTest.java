package com.maowei.learning.orm;

import com.maowei.learning.orm.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;

public class ORMTest {
    private static final Logger logger = Logger.getLogger(ORMTest.class);

    public static void main(String[] args) throws IOException{
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("spring/SqlMapConfig.xml"));

        SqlSession session1 = sqlSessionFactory.openSession(true);

        UserDao dao = session1.getMapper(UserDao.class);

        //dao.addUser(new User("A001","Bull",21));

        //session.commit();

        logger.debug("开始查询用户信息");

        logger.info("查询到用户id："+dao.findUserById("A001").getId());

        session1.commit();

        SqlSession session2 = sqlSessionFactory.openSession(true);

        dao = session2.getMapper(UserDao.class);

        logger.debug("再次查询用户信息");

        logger.info("查询到用户id："+dao.findUserById("A001").getId());

    }
}
