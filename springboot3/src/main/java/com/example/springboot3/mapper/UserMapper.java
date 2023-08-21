package com.example.springboot3.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot3.entity.User;
import com.example.springboot3.entity.dto.UserDTO;

public interface UserMapper extends BaseMapper<User> {

    @InterceptorIgnore(tenantLine = "true")
    UserDTO getUserDTO();

}
