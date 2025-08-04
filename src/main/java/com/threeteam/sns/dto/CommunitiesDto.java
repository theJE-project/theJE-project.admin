package com.threeteam.sns.dto;

import java.util.List;
import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;

public class CommunitiesDto {
    private Long	id;
    private String users;
    private Long	categories;
    private String	title = "";
    private String	content;
    private Long	count = 0L;
    private String hash = "";
    private LocalDateTime	created_at;
    private LocalDateTime	updated_at;
    private boolean	is_delete = false;
    private boolean	is_visible = true;
    private List<ImagesDto> images;
    private List<MusicsDto> musics;

    public CommunitiesDto() {}

    public CommunitiesDto(List<ImagesDto> images, List<MusicsDto> musics,  Long id, String hash, String users, Long categories, String title, String content, Long count, LocalDateTime created_at, LocalDateTime updated_at, boolean is_delete, boolean is_visible) {
        this.id = id;
        this.users = users;
        this.categories = categories;
        this.title = title;
        this.content = content;
        this.count = count;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.is_delete = is_delete;
        this.is_visible = is_visible;
        this.hash = hash;
        this.images = images;
        this.musics = musics;
    }


    public List<MusicsDto> getMusics() {
        return musics;
    }

    public void setMusics(List<MusicsDto> images) {
        this.musics = images;
    }
    public List<ImagesDto> getImages() {
        return images;
    }

    public void setImages(List<ImagesDto> images) {
        this.images = images;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getHash() {
        return hash;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public Long getCategories() {
        return categories;
    }

    public void setCategories(Long categories) {
        this.categories = categories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public LocalDateTime getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdatedAt() {
        return updated_at;
    }

    public void setUpdatedAt(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public boolean getIsDelete() {
        return is_delete;
    }

    public void setIsDelete(boolean is_delete) {
        this.is_delete = is_delete;
    }

    public boolean getIsVisible() {
        return is_visible;
    }

    public void setIsVisible(boolean is_visible) {
        this.is_visible = is_visible;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, users, categories, title, content, count, created_at, updated_at, is_delete, is_visible);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CommunitiesDto other = (CommunitiesDto) obj;
        return Objects.equals(id, other.id) && Objects.equals(users, other.users) && Objects.equals(categories, other.categories) && Objects.equals(title, other.title) && Objects.equals(content, other.content) && Objects.equals(count, other.count) && Objects.equals(created_at, other.created_at) && Objects.equals(updated_at, other.updated_at) && Objects.equals(is_delete, other.is_delete) && Objects.equals(is_visible, other.is_visible);
    }

    @Override
    public String toString() {
        return "CommunitiesDto [id=" + id + ", users=" + users + ", categories=" + categories + ", title=" + title + ", content=" + content + ", count=" + count + ", created_at=" + created_at + ", updated_at=" + updated_at + ", is_delete=" + is_delete + ", is_visible=" + is_visible + "]";
    }
}

