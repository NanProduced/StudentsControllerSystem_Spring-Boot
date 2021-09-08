package com.nan.studentsystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nan.studentsystem.entity.Register;
import com.nan.studentsystem.entity.User;
import com.nan.studentsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Nan
 * @since 2021-08-12
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(HttpSession session, String username, String password) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username", username);
        wrapper.eq("password", password);
        User user = userService.getOne(wrapper);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/register/getAll";
        } else return "redirect:/login-admin.html";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }
}

