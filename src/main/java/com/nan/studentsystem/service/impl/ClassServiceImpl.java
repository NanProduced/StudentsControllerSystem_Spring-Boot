package com.nan.studentsystem.service.impl;

import com.nan.studentsystem.VO.ClassVO;
import com.nan.studentsystem.entity.Class;
import com.nan.studentsystem.mapper.ClassMapper;
import com.nan.studentsystem.service.ClassService;
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
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements ClassService {

    @Autowired
    private ClassMapper classMapper;

    @Override
    public List<ClassVO> selectClass(Integer id) {
        return classMapper.selectClass(id);
    }
}
