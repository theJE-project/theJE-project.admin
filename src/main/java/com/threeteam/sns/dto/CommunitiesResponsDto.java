package com.threeteam.sns.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CommunitiesResponsDto {
    private Long	id;
    private UsersResponsDto users;
    private String	content;
    private Long	count ;
    private LocalDateTime created_at;
    private List<ImagesDto> images;
    private List<TracksDto> musics;

    public CommunitiesResponsDto(CommunitiesDto data, UsersResponsDto user,List<ImagesDto> images, List<TracksDto> musics) {
        this.id = data.getId();
        this.users = user;
        this.content = data.getContent();
        this.count = data.getCount();
        this.created_at = data.getCreatedAt();
        this.images = images;
        this.musics = musics;
    }
}
