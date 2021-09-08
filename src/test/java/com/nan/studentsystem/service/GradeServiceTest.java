package com.nan.studentsystem.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GradeServiceTest {

    @Autowired
    private GradeService gradeService;

    @Test
    void test() {
        gradeService.listAll().forEach(System.out::println);
    }

    @Test
    void test1() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name", "Nan");
        gradeService.listMaps(wrapper).forEach(System.out::println);
    }

    @Test
    void test2() {
        System.out.println(gradeService.getOneVO(1));
    }
}