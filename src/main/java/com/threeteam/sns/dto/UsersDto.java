package com.threeteam.sns.dto;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class UsersDto {
    private String	id;
    private String	account;
    private String	password;
    private String	role;
    private String	name;
    private String	email;
    private String	img;
    private Boolean	is_alert;
    private LocalDateTime	created_at;
    private LocalDateTime	updated_at;
    private String content;

}

