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
    private Long	categories;
    private String	title;
    private String	content;
    private Long	count ;
    private String hash ;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private boolean	is_delete;
    private boolean	is_visible;
    private List<ImagesDto> images;
    private List<TracksDto> musics;
//
//    public CommunitiesResponsDto(CommunitiesDto data, UsersResponsDto user,List<ImagesDto> images, List<TracksDto> musics) {
//        this.id = data.getId();
//        this.users = user;
//        this.content = data.getContent();
//        this.count = data.getCount();
//        this.created_at = data.getCreatedAt();
//        this.images = images;
//        this.musics = musics;
//    }

    public CommunitiesResponsDto(CommunitiesDto data, UsersResponsDto user,List<ImagesDto> images, List<TracksDto> musics) {
        this.id = data.getId();
        this.users = user;
        this.categories = data.getCategories();
        this.title = data.getTitle();
        this.content = data.getContent();
        this.count = data.getCount();
        this.hash = data.getHash();
        this.created_at = data.getCreatedAt();
        this.updated_at = data.getUpdatedAt();
        this.is_delete = data.getIsDelete();
        this.is_visible = data.getIsVisible();
        this.images = images;
        this.musics = musics;
    }
}
