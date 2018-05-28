package com.maowei.learning.orm;

import com.maowei.learning.orm.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ORMTest {
    private static final Logger logger = Logger.getLogger(ORMTest.class);

    public static void main(String[] args) throws IOException{
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("spring/SqlMapConfig.xml"));

        SqlSession session1 = sqlSessionFactory.openSession(true);
        //SqlSession session2 = sqlSessionFactory.openSession(true);
        //SqlSession session3 = sqlSessionFactory.openSession(true);


        UserDao dao1 = session1.getMapper(UserDao.class);
        //UserDao dao2 = session2.getMapper(UserDao.class);
        //UserDao dao3 = session3.getMapper(UserDao.class);

        //logger.debug("开始查询用户信息");

        //logger.info(dao1.findUserById("A001").toString());




        //logger.debug("新增用户信息");

        //dao.addUser(new User("A002","Cathy",24));

        //session.commit();

        //session1.commit();

        //logger.debug("新启回话，修改用户信息");

        //dao2.updateUserById(new User("A001","Alex",30));

        //logger.debug("再次查询用户信息");

        //logger.info(dao2.findUserById("A001").toString());

        //logger.debug("修改用户信息");

        //dao3.updateUserById(new User("A001","Alex",35));

        //session3.commit();

        //logger.debug("第三次查询用户信息");

        //logger.info(dao2.findUserById("A001").toString());

        Map<String,Object> map = new HashMap<String, Object>();
        int i = 0;
        int size = 0;

        do{
            System.out.println("当前显示结果第"+(++i)+"页：");
            map.put("pageSize",5);
            map.put("currPage",i);

            List<User> list = dao1.queryUserByPage(map);

            for(User u : list){
                System.out.println(u.toString());
            }

            System.out.println("======================");

            size = list.size();
        }while (size == 5);
    }
}
