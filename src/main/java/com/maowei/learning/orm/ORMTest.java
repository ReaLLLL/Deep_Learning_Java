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
        SqlSession session2 = sqlSessionFactory.openSession(true);
        SqlSession session3 = sqlSessionFactory.openSession(true);


        UserDao dao1 = session1.getMapper(UserDao.class);
        UserDao dao2 = session2.getMapper(UserDao.class);
        UserDao dao3 = session3.getMapper(UserDao.class);

        logger.debug("开始查询用户信息");

        logger.info(dao1.findUserById("A001").toString());

        //logger.debug("新增用户信息");

        //dao.addUser(new User("A002","Cathy",24));

        //logger.debug("新增用户信息");

        //dao.addUser(new User("A002","Cathy",24));

        //session.commit();

        session1.commit();

        //logger.debug("新启回话，修改用户信息");

        //dao2.updateUserById(new User("A001","Alex",30));

        logger.debug("再次查询用户信息");

        logger.info(dao2.findUserById("A001").toString());

        logger.debug("修改用户信息");

        dao3.updateUserById(new User("A001","Alex",35));

        session3.commit();

        logger.debug("第三次查询用户信息");

        logger.info(dao2.findUserById("A001").toString());
    }
}
