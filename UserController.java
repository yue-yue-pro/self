package com.yueyue.controller;

import com.yueyue.pojo.User;
import com.yueyue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(User loginUser, HttpSession session){
        User user = userService.login(loginUser);
        session.setAttribute("user", user);
        return "redirect:/account/queryAll";
    }
}