package com.nan.studentsystem.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nan.studentsystem.VO.AdminGradeVO;
import com.nan.studentsystem.VO.StudentGradeVO;
import com.nan.studentsystem.entity.Grade;
import org.apache.commons.beanutils.ConvertUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GradeMapperTest {

    @Autowired
    private GradeMapper gradeMapper;

    @Test
    void test() {
        List<StudentGradeVO> list = gradeMapper.findById(1);
    }

    @Test
    void Test1() {
        gradeMapper.findByName("Nan").forEach(System.out::println);
    }

    @Test
    void test3() {
        Page<Grade> page = new Page<>(1, 5, true);
        IPage<Grade> iPage = gradeMapper.selectPage(page, null);
        System.out.println("总页数:" + iPage.getPages());
        System.out.println("总记录数:" + iPage.getTotal());
        iPage.getRecords().forEach(System.out::println);
    }

    @Test
    void Test4() {
        Page<AdminGradeVO> page = new Page<>(2, 10, true);
        IPage<AdminGradeVO> iPage = gradeMapper.selectPage(page);
        List<AdminGradeVO> list = iPage.getRecords();
        System.out.println("Pages:" + iPage.getPages());
        System.out.println("Total:" + iPage.getTotal());
        System.out.println("current:" + iPage.getCurrent());
        System.out.println((iPage.getCurrent() - 1) * iPage.getSize() + 1);
        System.out.println((iPage.getCurrent() - 1) * iPage.getSize() + iPage.getSize());

//        System.out.println("总页数:" + iPage.getPages());
//        System.out.println("总记录数:" + iPage.getTotal());
//        iPage.getRecords().forEach(System.out::println);

    }
}