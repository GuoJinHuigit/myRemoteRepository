package com.guojh.project.service.impl;

import com.guojh.project.dao.UserDao;
import com.guojh.project.entity.User;
import com.guojh.project.service.UserService;
import com.guojh.project.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/11/3.
 */
@Service("us")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao ud;
    /*根据用户名和密码查询用户的方法*/
    @Override
    public User queryUserByUsername(String username, String password) {

        //根据用户名判断用户是否存在
        User user =ud.selectUserByUsernameAndPassword(username,null);
        if(user!=null){
            String oldPassword =user.getUserPassword();
            String salt =user.getUserSalt();
            String newPassword =MD5Util.jdkMD(password+salt);
            if(newPassword.equals(oldPassword)){
                return user;
            }else {
                return null;
            }
        }else {
            return null;
        }
    }
}
