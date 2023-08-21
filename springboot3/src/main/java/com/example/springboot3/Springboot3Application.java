package com.example.springboot3;

import com.example.springboot3.entity.dto.UserDTO;
import com.example.springboot3.service.IUserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@MapperScan("com.example.*.mapper")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RequestMapping("/")
public class Springboot3Application {

    @Autowired
    private IUserService userService;

    public static void main(String[] args) {
        SpringApplication.run(Springboot3Application.class, args);
    }

    @GetMapping("/userDTO")
    public UserDTO getUserDTO() {
        return userService.getUserDTO();
    }

}
