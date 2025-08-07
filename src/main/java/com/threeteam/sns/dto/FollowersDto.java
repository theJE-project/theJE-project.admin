package com.threeteam.sns.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class FollowersDto {
    private Integer	id;
    private String	follower;
    private String	followee;
    private LocalDateTime	created_at;
    
}
