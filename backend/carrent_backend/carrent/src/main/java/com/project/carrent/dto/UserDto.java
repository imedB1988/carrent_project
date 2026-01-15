package com.project.carrent.dto;

import com.project.carrent.enums.UserRole;

import lombok.Data;

@Data
public class UserDto {

    private Long Id;
    private String name;
    private String email;
    private String password;
    private UserRole userRole;

}
