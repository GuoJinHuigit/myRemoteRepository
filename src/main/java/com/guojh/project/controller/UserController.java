package com.guojh.project.controller;

import com.guojh.project.entity.User;
import com.guojh.project.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;


/**
 * Created by Administrator on 2017/11/3.
 */
@Controller
@RequestMapping("/admin")
public class UserController {

    @Resource
    private UserService us;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView login(String username,String password){
        User user =us.queryUserByUsername(username,password);
        ModelAndView modelAndView =new ModelAndView();
        if(user != null){
            modelAndView.setViewName("redirect:/back/show/main.jsp");
            return modelAndView;
        }else {
            modelAndView.setViewName("redirect:/back/show/login.jsp");
            return modelAndView;
        }
    }
}
