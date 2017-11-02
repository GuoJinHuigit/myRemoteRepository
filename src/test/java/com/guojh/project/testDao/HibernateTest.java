package com.guojh.project.testDao;

import com.guojh.project.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.apache.shiro.web.filter.mgt.DefaultFilter.user;

/**
 * Created by Administrator on 2017/10/26.
 */

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-hibernate.xml"})*/
public class HibernateTest {


    /*添加数据，新增*/
    @Test
    public void testHibernate() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-hibernate.xml");
        //从spring容器中获取我们的会话工厂实例，里面已完成好各个属性的配置工作
        SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");

        //下面开始我们的数据库操作
        Session session = sessionFactory.openSession();//从会话工厂获取一个session
        Transaction transaction = session.beginTransaction();//开启一个新的事务
        User user = new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setUserName("郭龙");
        user.setUserMobilePhone("13000114444");
        user.setUserSex("男");
        user.setUserStatus("1");
        session.save(user);
        transaction.commit();//提交事务
    }

    /*查询测试*/
    @Test
    public void testQuery() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-hibernate.xml");
        //从spring容器中获取我们的会话工厂实例，里面已完成好各个属性的配置工作
        SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");

        //下面开始我们的数据库操作
        Session session = sessionFactory.openSession();//从会话工厂获取一个session
        Transaction transaction = session.beginTransaction();//开启一个新的事务
        String hiSql = "from User u where u.userName=? and u.userMobilePhone = ?";
        Query query = session.createQuery(hiSql);
        query.setString(0,"郭龙");
        query.setString(1,"13000114444");
        User user = (User) query.uniqueResult();//返回一个对象使用uniqueResult，返回集合使用list方法
        System.out.print(user);
        transaction.commit();//提交事务
        session.close();
    }

    /*hibernate的getCurrentSession 和opsession区别
    * getCurrentSession创建的线程会在事务回滚或事物提交后自动关闭,而openSession必须手动关闭
    * getCurrentSession创建的session会和绑定到当前线程,而openSession不会，
    * openSession每次都会创建一个新的session对象，而GetCurrentSession获得的是当前县城绑定的session对象*/

    /*删除数据,第一种方式
    * hibernate删除数据时会先根据*/
    @Test
    public void testDelete(){
        try {
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-hibernate.xml");
            SessionFactory sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
            Session session = sessionFactory.getCurrentSession();
            Transaction tx = session.beginTransaction();//开启事物
            String hSql = "delete from User where userName=? and userMobilePhone=?";
            Query query =session.createQuery(hSql);
            query.setString(0,"郭龙");
            query.setString(1,"13000114444");
            query.executeUpdate();
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*删除数据，第二种方式*/
    @Test
    public void testDelete2(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-hibernate.xml");
        SessionFactory sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();//开启事物
        String userId = "3f84e8cc-7992-41c5-8c9c-0b26ad852609";
        User user = session.get(User.class,userId);
        session.delete(user);
        tx.commit();

    }

    /*删除数据 第三种方式 懒加载不行
    * get方法加载的时候会立刻发出sql语句去查询，而load方法在执行的时候没有立刻的发出sql去查询，
    * 生成一个代理User，没有生成真正的User。当我们真正的去用这个user的时候才会加载真正的User。
    * Load（）支持延迟加载，而Get（）不支持延迟加载。Get加载的对象不存在时返回的是null对象，
    * 而Load（）加载对象不存在时会抛出ObjectNotFoundException异常。*/
    @Test
    public void testDelete3(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-hibernate.xml");
        SessionFactory sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
        Session session = sessionFactory.getCurrentSession();//根据ID删除，设置其他属性不起作用
        Transaction tx = session.beginTransaction();//开启事物
        String userId="3f84e8cc-7992-41c5-8c9c-0b26ad852609";
        User user =  session.load(User.class,userId);
        session.delete(user);
        tx.commit();
    }

    /*hibernate修改数据
    第一种方式update方法
     */
    @Test
    public void testupdate1(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-hibernate.xml");
        SessionFactory sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
        Session session = sessionFactory.getCurrentSession();//根据ID删除，设置其他属性不起作用
        Transaction tx = session.beginTransaction();//开启事物
        User user = new User();
        user.setUserId("64447402-9f70-44ce-a48e-1ab23b437729");
        user.setUserName("海军");
        user.setUserMobilePhone("13300000000");
        session.update(user);
        tx.commit();
    }

    /*第二种方法 HQL*/
    @Test
    public void testUpdate2(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-hibernate.xml");
        SessionFactory sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
        Session session = sessionFactory.getCurrentSession();//根据ID删除，设置其他属性不起作用
        Transaction tx = session.beginTransaction();//开启事物
        String HQL = "update User set userName=?,userMobilePhone=? where userId = ?";
        Query query =session.createQuery(HQL);
        query.setString(0,"红霞");
        query.setString(1,"13800001111");
        query.setString(2,"64447402-9f70-44ce-a48e-1ab23b437729");
        query.executeUpdate();
        tx.commit();

    }

    /*hibernate分页查询*/
    @Test
    public void testQueryByPage(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-hibernate.xml");
        SessionFactory sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
        Session session = sessionFactory.getCurrentSession();//根据ID删除，设置其他属性不起作用
        Transaction tx = session.beginTransaction();//开启事物
        int begin = 2;//从那个下标位置开始取数据
        int end = 4;//取多少条数据==每页显示数据
        List<User> users =session.createQuery("from User")
                .setFirstResult(begin)
                .setMaxResults(end)
                .list();
        Query query =session.createQuery("select count(*) from User");

        for(User user:users){
            System.out.print("用户有"+user);
        }
        Long count = (Long) query.uniqueResult();
        tx.commit();
        System.out.println("总数==="+count);
    }

}
