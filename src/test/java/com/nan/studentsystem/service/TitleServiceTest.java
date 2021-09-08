package com.nan.studentsystem.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TitleServiceTest {

    @Autowired
    private TitleService titleService;

    @Test
    void test() {
        titleService.orderByTime().forEach(System.out::println);
    }
}