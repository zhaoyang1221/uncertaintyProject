package com.xzy.uncertainty.controller;

import com.xzy.uncertainty.pojo.User;
import com.xzy.uncertainty.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author Administrator on 2016/11/21 0021.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping("/showUser/{id}")
    @ResponseBody
    public User toIndex(@PathVariable int id){
        return userService.getUserById(id);
    }

    @RequestMapping("/gotoShow")
    public String gotoShow(){
        return "showUser";
    }
}
