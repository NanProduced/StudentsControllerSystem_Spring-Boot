package com.nan.studentsystem.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.nan.studentsystem.entity.Register;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RegisterServiceTest {

    @Autowired
    private RegisterService registerService;

    @Test
    void test() {
        Register register = new Register();
        register.setId(1);
        register.setName("NNan");
        register.setEmail("646984446@qq.com");

        registerService.updateById(register);
    }
}