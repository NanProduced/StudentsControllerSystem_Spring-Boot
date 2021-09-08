package com.nan.studentsystem.service.impl;

import com.nan.studentsystem.entity.User;
import com.nan.studentsystem.mapper.UserMapper;
import com.nan.studentsystem.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
