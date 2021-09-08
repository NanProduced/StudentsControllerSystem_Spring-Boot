package com.nan.studentsystem.service;

import com.nan.studentsystem.entity.Title;
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
public interface TitleService extends IService<Title> {

    public List<Title> orderByTime();
}
