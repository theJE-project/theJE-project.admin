package com.threeteam.sns.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UsersPendingDto {
    private UsersDto user;
    //private long createdAt; // timestamp
    private Long create_at;
    
    public UsersPendingDto(UsersDto user) {
        this.user = user;
        this.create_at = System.currentTimeMillis();
    }
    
}
