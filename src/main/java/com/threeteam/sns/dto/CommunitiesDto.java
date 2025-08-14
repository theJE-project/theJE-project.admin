package com.threeteam.sns.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class CommunitiesDto {
    private Integer	id;
    private String	users;
    private Integer	categories;
    private String	title ="";
    private String	content;
    private Integer	count = 0;
    private String hash = "";
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private Boolean	is_delete = false;
    private Boolean	is_visible = true;
    private List<ImagesDto> images;
    private List< MusicsDto> musics;
    
    private String follower;
    private String followee;
}

