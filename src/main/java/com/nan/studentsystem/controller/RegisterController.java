package com.nan.studentsystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nan.studentsystem.VO.StudentGradeVO;
import com.nan.studentsystem.entity.Register;
import com.nan.studentsystem.service.GradeService;
import com.nan.studentsystem.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Nan
 * @since 2021-08-12
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private GradeService gradeService;

    @PostMapping("/StudentRegister")
    public String register(Register register, Model model) {
        boolean result = false;
        try {
            result = registerService.save(register);
        } catch (Exception e) {
            model.addAttribute("error", "用户名已存在!");
            return "register";
        }
        if (result) return "redirect:/login.html";
        return "redirect:/register.html";
    }

    @PostMapping("/login")
    public String login(String name, String password, HttpSession session) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name", name);
        wrapper.eq("password", password);
        Register register = registerService.getOne(wrapper);
        if (register != null) {
            session.setAttribute("student", register);
            return "student_index";
        } else {
            return "redirect:/login.html";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }

    @GetMapping("/getAll")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView();
        Page<Register> page = new Page<>(1, 10, true);
        IPage<Register> ipage = registerService.page(page);
        modelAndView.setViewName("admin_index");
        List<Register> list = ipage.getRecords();
        modelAndView.addObject("students", list);
        modelAndView.addObject("pages", ipage.getPages());
        modelAndView.addObject("size", ipage.getSize());
        modelAndView.addObject("total", ipage.getTotal());
        modelAndView.addObject("current", ipage.getCurrent());
        return modelAndView;
    }

    @GetMapping("/page/{current}/{size}")
    public ModelAndView page(@PathVariable("current") Integer current, @PathVariable("size") Integer size) {
        Page<Register> page = new Page<>(current, size, true);
        IPage<Register> ipage = registerService.page(page);
        List<Register> list = ipage.getRecords();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin_index");
        modelAndView.addObject("students", list);
        modelAndView.addObject("pages", ipage.getPages());
        modelAndView.addObject("size", ipage.getSize());
        modelAndView.addObject("total", ipage.getTotal());
        modelAndView.addObject("current", ipage.getCurrent());
        return modelAndView;
    }

    @GetMapping("/getDetail/{id}")
    public ModelAndView getDetail(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin_student");
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id", id);
        Register register = registerService.getOne(wrapper);
        modelAndView.addObject("student", register);
        List<StudentGradeVO> list = gradeService.listById(id);
        modelAndView.addObject("gradeList", list);
        return modelAndView;

    }

    @GetMapping("/getByName/{name}")
    public ModelAndView getByName(@PathVariable("name") String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin_student");
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name", name);
        modelAndView.addObject("student", registerService.getOne(wrapper));
        modelAndView.addObject("gradeList", gradeService.listByName(name));
        return modelAndView;
    }

    @GetMapping("/getOne/{id}")
    public ModelAndView getOne(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin_modiStudent");
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id", id);
        Register register = registerService.getOne(wrapper);
        modelAndView.addObject("student", register);
        return modelAndView;
    }

    @PostMapping("/modifyStudent")
    public String ModifyStudent(Integer id, String name, String sex, String email) {
        Register register = new Register();
        register.setId(id);
        if (name != null) register.setName(name);
        if (sex != null) register.setSex(sex);
        if (email != null) register.setEmail(email);
        registerService.updateById(register);
        return "redirect:/register/getDetail/" + id;

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        registerService.removeById(id);
        return "redirect:/register/getAll";
    }
}

