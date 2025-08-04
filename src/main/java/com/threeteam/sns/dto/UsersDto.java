package com.threeteam.sns.dto;

import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;

public class UsersDto {
    private String	id;
    private String	account;
    private String	password;
    private String	role;
    private String	name;
    private String	email;
    private String	img;
    private boolean	is_alert;
    private String content;


    public UsersDto() {}

    public UsersDto(String id, String account, String password, String role, String name, String email, String img, boolean is_alert, String content) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.role = role;
        this.name = name;
        this.email = email;
        this.img = img;
        this.is_alert = is_alert;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean getIsAlert() {
        return is_alert;
    }

    public void setIsAlert(boolean is_alert) {
        this.is_alert = is_alert;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, account, password, role, name, email, img, is_alert, content);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UsersDto other = (UsersDto) obj;
        return Objects.equals(id, other.id) && Objects.equals(account, other.account) && Objects.equals(password, other.password) && Objects.equals(role, other.role) && Objects.equals(name, other.name) && Objects.equals(email, other.email) && Objects.equals(img, other.img) && Objects.equals(is_alert, other.is_alert)  && Objects.equals(content, other.content);
    }

    @Override
    public String toString() {
        return "UsersDto [id=" + id + ", account=" + account + ", password=" + password + ", role=" + role + ", name=" + name + ", email=" + email + ", img=" + img + ", is_alert=" + is_alert + ",content =" +content +"]";
    }
}

