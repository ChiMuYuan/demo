package com.example.springboot3.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot3.entity.User;
import com.example.springboot3.entity.dto.UserDTO;

public interface IUserService extends IService<User> {

    UserDTO getUserDTO();

}
