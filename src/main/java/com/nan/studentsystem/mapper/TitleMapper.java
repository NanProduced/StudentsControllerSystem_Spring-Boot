package com.nan.studentsystem.mapper;

import com.nan.studentsystem.entity.Title;
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
public interface TitleMapper extends BaseMapper<Title> {

    @Select("select * from title order by time DESC")
    public List<Title> orderByTime();

}
