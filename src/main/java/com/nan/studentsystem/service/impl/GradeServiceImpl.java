package com.nan.studentsystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nan.studentsystem.VO.AdminGradeVO;
import com.nan.studentsystem.VO.StudentGradeVO;
import com.nan.studentsystem.entity.Grade;
import com.nan.studentsystem.mapper.GradeMapper;
import com.nan.studentsystem.service.GradeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Nan
 * @since 2021-08-12
 */
@Service
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade> implements GradeService {

    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public List<StudentGradeVO> listById(Integer id) {
        return gradeMapper.findById(id);
    }

    @Override
    public List<StudentGradeVO> listByName(String name) {
        return gradeMapper.findByName(name);
    }

    @Override
    public List<AdminGradeVO> listAll() {
        return gradeMapper.listAll();
    }

    @Override
    public AdminGradeVO getOneVO(Integer id) {
        return gradeMapper.getOneVO(id);
    }

    @Override
    public IPage<AdminGradeVO> PageAll(Integer current, Integer size) {
        Page<AdminGradeVO> page = new Page<>(current, size, true);
        return gradeMapper.selectPage(page);
    }
}
