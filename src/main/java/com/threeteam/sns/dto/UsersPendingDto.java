package com.threeteam.sns.dto;

public class UsersPendingDto {
    private UsersDto user;
    private long createdAt; // timestamp

    public UsersPendingDto(UsersDto user) {
        this.user = user;
        this.createdAt = System.currentTimeMillis();
    }

    public UsersDto getUser() {
        return user;
    }

    public long getCreatedAt() {
        return createdAt;
    }
}
