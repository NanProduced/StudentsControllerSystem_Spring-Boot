package com.nan.studentsystem.service;

import com.nan.studentsystem.VO.ClassVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClassServiceTest {

    @Autowired
    private ClassService classService;

    @Test
    void test() {
        classService.selectClass(1).forEach(System.out::println);
    }
}