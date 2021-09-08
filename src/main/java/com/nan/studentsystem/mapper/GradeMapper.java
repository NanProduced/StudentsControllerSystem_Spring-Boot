package com.nan.studentsystem.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nan.studentsystem.VO.AdminGradeVO;
import com.nan.studentsystem.VO.StudentGradeVO;
import com.nan.studentsystem.entity.Grade;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Nan
 * @since 2021-08-12
 */
public interface GradeMapper extends BaseMapper<Grade> {

    @Select("select classname,grade from class,grade where stu_id = #{id} and class_id = class.id")
    public List<StudentGradeVO> findById(Integer id);

    @Select("select 11c.class.classname,11c.grade.grade from 11c.class,11c.grade where 11c.grade.class_id = 11c.class.id and 11c.grade.stu_id in (select 11c.register.id from 11c.register where 11c.register.name = #{name} )")
    public List<StudentGradeVO> findByName(String name);

    @Select("select 11c.grade.id gradeID,11c.register.name stuName,11c.class.classname className,11c.grade.grade stuGrade from 11c.grade,11c.class,11c.register where 11c.grade.stu_id = 11c.register.id and 11c.grade.class_id = 11c.class.id order by class_id")
    public List<AdminGradeVO> listAll();

    @Select("select 11c.grade.id gradeID,11c.register.name stuName,11c.class.classname className,11c.grade.grade stuGrade from 11c.grade,11c.class,11c.register where 11c.grade.stu_id = 11c.register.id and 11c.grade.id = #{id} and 11c.grade.class_id = 11c.class.id order by class_id")
    public AdminGradeVO getOneVO(Integer id);


    @Select("select 11c.grade.id gradeID,11c.register.name stuName,11c.class.classname className,11c.grade.grade stuGrade from 11c.grade,11c.class,11c.register where 11c.grade.stu_id = 11c.register.id and 11c.grade.class_id = 11c.class.id order by class_id")
    public IPage<AdminGradeVO> selectPage(IPage<AdminGradeVO> page);

}
