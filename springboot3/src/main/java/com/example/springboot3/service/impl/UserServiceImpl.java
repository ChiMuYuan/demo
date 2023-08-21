package com.example.springboot3.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot3.entity.User;
import com.example.springboot3.entity.dto.UserDTO;
import com.example.springboot3.mapper.UserMapper;
import com.example.springboot3.service.IUserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ChiMu Yuan
 * @since 2021-03-19
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDTO getUserDTO() {
        return userMapper.getUserDTO();
    }

}
