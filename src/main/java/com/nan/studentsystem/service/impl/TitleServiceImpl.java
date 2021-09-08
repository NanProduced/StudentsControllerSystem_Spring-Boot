package com.nan.studentsystem.service.impl;

import com.nan.studentsystem.entity.Title;
import com.nan.studentsystem.mapper.TitleMapper;
import com.nan.studentsystem.service.TitleService;
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
public class TitleServiceImpl extends ServiceImpl<TitleMapper, Title> implements TitleService {

    @Autowired
    private TitleMapper titleMapper;

    @Override
    public List<Title> orderByTime() {
        return titleMapper.orderByTime();
    }
}
