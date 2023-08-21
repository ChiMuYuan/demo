package com.example.springboot3.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot3.entity.User;
import com.example.springboot3.entity.dto.UserDTO;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author ChiMu Yuan
 * @since 2021-03-19
 */
public interface IUserService extends IService<User> {

    UserDTO getUserDTO();

}
