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
    private boolean is_following;

    public boolean isIs_alert() {
        return is_alert;
    }
    public void setIs_alert(boolean is_alert) {
        this.is_alert = is_alert;
    }

    public UsersResponsDto(UsersDto user, boolean is_following) {
        this.id = user.getId();
        this.account = user.getAccount();
        this.role = user.getRole();
        this.name = user.getName();
        this.email = user.getEmail();
        this.img = user.getImg();
        this.is_alert = user.getIs_alert();
        this.content = user.getContent();
        this.is_following = is_following;
    }
}
