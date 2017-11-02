package com.guojh.project.dao;

import com.guojh.project.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 */
public interface UserDao {

    /*查询所有用户*/
    public List<User> selectAllUser();
    /*根据用户名和密码查询用户*/
    public User selectUserByUsernameAndPassword(String username,String password);
    /*添加用户*/
    public void saveUser(User user);
    /*更新用户*/
    public void updateUser(User user);
    /*根据主键删除用户*/
    public void deleteUserById(String Id);
}
