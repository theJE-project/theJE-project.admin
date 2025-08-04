package com.threeteam.sns.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersResponsDto {
    private String	id;
    private String	account;
    private String	role;
    private String	name;
    private String	email;
    private String	img;
    private boolean	is_alert;
    private String  content;

    public boolean isIs_alert() {
        return is_alert;
    }
    public void setIs_alert(boolean is_alert) {
        this.is_alert = is_alert;
    }

    public UsersResponsDto(UsersDto user) {
        this.id = user.getId();
        this.account = user.getAccount();
        this.role = user.getRole();
        this.name = user.getName();
        this.email = user.getEmail();
        this.img = user.getImg();
        this.is_alert = user.getIsAlert();
        this.content = user.getContent();
    }
}
