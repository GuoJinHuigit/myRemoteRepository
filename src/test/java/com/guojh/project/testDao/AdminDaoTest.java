package com.guojh.project.testDao;

import com.guojh.project.dao.UserDao;
import com.guojh.project.entity.User;
import com.guojh.project.util.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/11/4.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/spring-hibernate.xml")
public class AdminDaoTest {

    @Autowired
    private UserDao ud;

    @Test
    public void testSelectUserByUserName(){
        User user =ud.selectUserByUsernameAndPassword("guojinhui",null);
        System.out.println("yonghu===="+user);
    }

    @Test
    public void testMd5Password(){
        User user =ud.selectUserByUsernameAndPassword("guojinhui",null);
        String userSalt = user.getUserSalt();
        String passwod = "888888";
        String jdkMD = MD5Util.jdkMD(passwod + userSalt);
        System.out.print(jdkMD);
        System.out.println(jdkMD.equals(user.getUserPassword()));

        //guojinhui:888888
    }

}
