package com.nan.studentsystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nan.studentsystem.VO.AdminGradeVO;
import com.nan.studentsystem.VO.StudentGradeVO;
import com.nan.studentsystem.entity.Grade;
import com.nan.studentsystem.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

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
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping("/get/{id}")
    public ModelAndView getGrade(@PathVariable("id") Integer id) {
        List<StudentGradeVO> list = gradeService.listById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("grade");
        modelAndView.addObject("gradeList", list);
        return modelAndView;

    }

    @GetMapping("/getAll")
    public ModelAndView getAll() {
        int current = 1;
        int size = 15;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin_grade");
        IPage<AdminGradeVO> iPage = gradeService.PageAll(current, size);
        List<AdminGradeVO> list = iPage.getRecords();
        modelAndView.addObject("total", iPage.getTotal());
        modelAndView.addObject("current", iPage.getCurrent());
        modelAndView.addObject("pages", iPage.getPages());
        modelAndView.addObject("size", iPage.getSize());
        modelAndView.addObject("gradeList", list);
        return modelAndView;
    }

    @GetMapping("/page/{current}/{size}")
    public ModelAndView page(@PathVariable("current") Integer current, @PathVariable("size") Integer size) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin_grade");
        IPage<AdminGradeVO> iPage = gradeService.PageAll(current, size);
        List<AdminGradeVO> list = iPage.getRecords();
        modelAndView.addObject("total", iPage.getTotal());
        modelAndView.addObject("current", iPage.getCurrent());
        modelAndView.addObject("pages", iPage.getPages());
        modelAndView.addObject("size", iPage.getSize());
        modelAndView.addObject("gradeList", list);
        return modelAndView;
    }


    @GetMapping("/getOne/{id}")
    public ModelAndView getOne(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin_modiCourse");
        modelAndView.addObject("info", gradeService.getOneVO(id));
        return modelAndView;
    }

    @PostMapping("/modify")
    public String modify(Integer id, String score) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id", id);
        Grade grade = gradeService.getOne(wrapper);
        grade.setGrade(score);
        gradeService.updateById(grade);
        return "redirect:/grade/getAll";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        gradeService.removeById(id);
        return "redirect:/grade/getAll";
    }
}

