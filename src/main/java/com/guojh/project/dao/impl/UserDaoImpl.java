package com.guojh.project.dao.impl;

import com.guojh.project.dao.UserDao;
import com.guojh.project.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/11/3.
 */
@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<User> selectAllUser() {
        Session session =sessionFactory.getCurrentSession();
        String hql="from User";
        Query query =session.createQuery(hql);
        List<User> users =query.list();
        return users;
    }

    @Override
    public User selectUserByUsernameAndPassword(String username, String password) {
        Session session =sessionFactory.getCurrentSession();
        String hql ="from User u where u.userName=?";
        Query query =session.createQuery(hql);
        query.setString(0,username);
        User user = (User) query.uniqueResult();
        return user;
    }

    @Override
    public void saveUser(User user) {
        Session session =sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public void updateUser(User user) {
        Session session =sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public void deleteUserById(String Id) {
        Session session =sessionFactory.getCurrentSession();
        session.delete(Id,User.class);
    }
}
