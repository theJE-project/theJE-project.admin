package com.threeteam.sns.dto;

import lombok.Data;

@Data
public class UsersResponsDto {
    private String	id;
    private String	account;
    private String	role;
    private String	name;
    private String	email;
    private String	img;
    private Boolean	is_alert;
    private String  content;

    public UsersResponsDto(UsersDto user) {
        this.id = user.getId();
        this.account = user.getAccount();
        this.role = user.getRole();
        this.name = user.getName();
        this.email = user.getEmail();
        this.img = user.getImg();
        this.is_alert = user.getIs_alert();
        this.content = user.getContent();
    }
    
}
