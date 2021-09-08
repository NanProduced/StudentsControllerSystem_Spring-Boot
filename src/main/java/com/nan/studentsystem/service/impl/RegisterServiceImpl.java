package com.nan.studentsystem.service.impl;

import com.nan.studentsystem.entity.Register;
import com.nan.studentsystem.mapper.RegisterMapper;
import com.nan.studentsystem.service.RegisterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Nan
 * @since 2021-08-12
 */
@Service
public class RegisterServiceImpl extends ServiceImpl<RegisterMapper, Register> implements RegisterService {

}
