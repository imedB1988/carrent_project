package com.project.carrent.entity;

import com.project.carrent.enums.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;
    private String name;
    private String email;
    private String password;
    private UserRole userRole;


}
