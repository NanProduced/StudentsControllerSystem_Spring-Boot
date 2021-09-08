package com.nan.studentsystem.service;

import com.nan.studentsystem.VO.ClassVO;
import com.nan.studentsystem.entity.Class;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Nan
 * @since 2021-08-12
 */
public interface ClassService extends IService<Class> {
    public List<ClassVO> selectClass(Integer id);
}
