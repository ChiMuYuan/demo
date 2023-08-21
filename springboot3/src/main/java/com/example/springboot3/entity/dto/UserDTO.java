package com.example.springboot3.entity.dto;

import com.example.springboot3.entity.SysRole;
import com.example.springboot3.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class UserDTO extends User {

    private List<SysRole> roleList;

}
