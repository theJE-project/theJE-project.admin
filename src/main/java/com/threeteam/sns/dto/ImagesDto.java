package com.threeteam.sns.dto;

import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;

public class ImagesDto {
    private Long	id;
    private Long	board;
    private Long	board_types;
    private String	url;
    private boolean	is_main = true;
    private LocalDateTime	created_at;

    public ImagesDto() {}

    public ImagesDto(Long id, Long board, Long board_types, String url, boolean is_main, LocalDateTime created_at) {
        this.id = id;
        this.board = board;
        this.board_types = board_types;
        this.url = url;
        this.is_main = is_main;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBoard() {
        return board;
    }

    public void setBoard(Long board) {
        this.board = board;
    }

    public Long getBoardTypes() {
        return board_types;
    }

    public void setBoardTypes(Long board_types) {
        this.board_types = board_types;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean getIsMain() {
        return is_main;
    }

    public void setIsMain(boolean is_main) {
        this.is_main = is_main;
    }

    public LocalDateTime getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, board, board_types, url, is_main, created_at);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ImagesDto other = (ImagesDto) obj;
        return Objects.equals(id, other.id) && Objects.equals(board, other.board) && Objects.equals(board_types, other.board_types) && Objects.equals(url, other.url) && Objects.equals(is_main, other.is_main) && Objects.equals(created_at, other.created_at);
    }

    @Override
    public String toString() {
        return "ImagesDto [id=" + id + ", board=" + board + ", board_types=" + board_types + ", url=" + url + ", is_main=" + is_main + ", created_at=" + created_at + "]";
    }
}

