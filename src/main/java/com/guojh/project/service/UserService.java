package com.guojh.project.service;

import com.guojh.project.entity.User;

/**
 * Created by Administrator on 2017/11/3.
 */
public interface UserService {

    public User queryUserByUsername(String username,String password);
}
