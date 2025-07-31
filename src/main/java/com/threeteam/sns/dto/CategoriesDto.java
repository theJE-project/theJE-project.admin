package com.threeteam.sns.dto;

import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;

public class CategoriesDto {
    private Long	id;
    private Long	parent;
    private String	name;
    private String	url;
    private Long	board_type;
    private LocalDateTime	created_at;

    public CategoriesDto() {}

    public CategoriesDto(Long id, Long parent, String name, String url, Long board_type, LocalDateTime created_at) {
        this.id = id;
        this.parent = parent;
        this.name = name;
        this.url = url;
        this.board_type = board_type;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getBoardType() {
        return board_type;
    }

    public void setBoardType(Long board_type) {
        this.board_type = board_type;
    }

    public LocalDateTime getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parent, name, url, board_type, created_at);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CategoriesDto other = (CategoriesDto) obj;
        return Objects.equals(id, other.id) && Objects.equals(parent, other.parent) && Objects.equals(name, other.name) && Objects.equals(url, other.url) && Objects.equals(board_type, other.board_type) && Objects.equals(created_at, other.created_at);
    }

    @Override
    public String toString() {
        return "CategoriesDto [id=" + id + ", parent=" + parent + ", name=" + name + ", url=" + url + ", board_type=" + board_type + ", created_at=" + created_at + "]";
    }
}

