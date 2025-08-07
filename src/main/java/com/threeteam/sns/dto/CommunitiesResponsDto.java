package com.threeteam.sns.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class CommunitiesResponsDto {
    private Integer	id;
    private UsersResponsDto users;
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
        this.created_at = data.getCreated_at();
        this.updated_at = data.getUpdated_at();
        this.is_delete = data.getIs_delete();
        this.is_visible = data.getIs_visible();
        this.images = images;
        this.musics = musics;
    }
}
