package com.nan.studentsystem.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nan.studentsystem.entity.Class;
import com.nan.studentsystem.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Nan
 * @since 2021-08-12
 */
@Controller
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping("/course")
    public ModelAndView course() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("course");
        List<Class> list = new ArrayList<>();
        list = classService.list(null);
        modelAndView.addObject("list", list);
        return modelAndView;

    }

    @GetMapping("/adminCourse")
    public ModelAndView adminCourse() {
        int current = 1;
        int size = 6;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin_course");
        Page<Class> page = new Page<>(current, size);
        IPage<Class> iPage = classService.page(page, null);
        List<Class> list = iPage.getRecords();
        modelAndView.addObject("pages", iPage.getPages());
        modelAndView.addObject("total", iPage.getTotal());
        modelAndView.addObject("current", iPage.getCurrent());
        modelAndView.addObject("size", iPage.getSize());
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @GetMapping("/page/{current}/{size}")
    public ModelAndView page(@PathVariable("current") Integer current, @PathVariable("size") Integer size) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin_course");
        Page<Class> page = new Page<>(current, size);
        IPage<Class> iPage = classService.page(page, null);
        List<Class> list = iPage.getRecords();
        modelAndView.addObject("pages", iPage.getPages());
        modelAndView.addObject("total", iPage.getTotal());
        modelAndView.addObject("current", iPage.getCurrent());
        modelAndView.addObject("size", iPage.getSize());
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(Class CLASS) {
        classService.save(CLASS);
        return "redirect:/class/adminCourse";
    }

    @GetMapping("/check/{id}")
    public ModelAndView check(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin_class");
        modelAndView.addObject("class", classService.getById(id));
        modelAndView.addObject("classStu", classService.selectClass(id));
        return modelAndView;

    }
}

