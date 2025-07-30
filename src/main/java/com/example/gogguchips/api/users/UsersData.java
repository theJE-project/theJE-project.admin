package com.example.gogguchips.api.users;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
public class UsersData {
    private String id;
    private String account;
    private String password;
    private String role;
    private String name;
    private String email;
    private String img;
    private boolean isAlert;
}