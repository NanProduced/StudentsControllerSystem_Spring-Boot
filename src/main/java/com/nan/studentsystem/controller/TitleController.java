package com.nan.studentsystem.controller;


import com.nan.studentsystem.entity.Title;
import com.nan.studentsystem.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
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
@RequestMapping("/title")
public class TitleController {

    @Autowired
    private TitleService titleService;

    @GetMapping("/get")
    public ModelAndView getTitle() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("text");
        List<Title> titleList = titleService.orderByTime();
        modelAndView.addObject("titleList", titleList);
        return modelAndView;
    }

    @GetMapping("/adminTitle")
    public ModelAndView adminTitle() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin_text");
        List<Title> titleList = titleService.orderByTime();
        modelAndView.addObject("titleList", titleList);
        return modelAndView;
    }

    @GetMapping("/getOne/{id}")
    public ModelAndView getOne(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin_ModifyText");
        Title title = titleService.getById(id);
        modelAndView.addObject("title", title);
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(Title title) {
        titleService.save(title);
        return "redirect:/title/adminTitle";
    }

    @PostMapping("/modify")
    public String modify(Integer id, String head, String text) {
        Title title = new Title();
        title.setId(id);
        title.setTime(LocalDateTime.now());
        if (head != null) title.setHead(head);
        if (text != null) title.setText(text);
        titleService.updateById(title);
        return "redirect:/title/adminTitle";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        titleService.removeById(id);
        return "redirect:/title/adminTitle";
    }


}

