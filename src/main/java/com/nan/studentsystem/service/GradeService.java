package com.nan.studentsystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nan.studentsystem.VO.AdminGradeVO;
import com.nan.studentsystem.VO.StudentGradeVO;
import com.nan.studentsystem.entity.Grade;
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
public interface GradeService extends IService<Grade> {

    public List<StudentGradeVO> listById(Integer id);

    public List<StudentGradeVO> listByName(String name);

    public List<AdminGradeVO> listAll();

    ;

    public AdminGradeVO getOneVO(Integer id);

    public IPage<AdminGradeVO> PageAll(Integer current, Integer size);
}
