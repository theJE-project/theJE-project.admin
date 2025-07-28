package com.example.gogguchips.api.users;
import lombok.Data;

@Data
public class UsersData {
    private String id;
    private String account;
    private String password;
    private Long locations;
    private String role;
    private String name;
    private String email;
    private String img;
    private boolean isAlert;
}