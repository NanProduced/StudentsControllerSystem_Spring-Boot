package com.nan.studentsystem.mapper;

import com.nan.studentsystem.VO.ClassVO;
import com.nan.studentsystem.entity.Class;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface ClassMapper extends BaseMapper<Class> {

    @Select("select 11c.register.id stuID,11c.register.name stuName,11c.register.sex stuSex,11c.grade.grade stuGrade from 11c.register,11c.grade where 11c.grade.class_id = #{id} and 11c.grade.stu_id = 11c.register.id")
    public List<ClassVO> selectClass(Integer id);

}
