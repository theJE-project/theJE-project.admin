package com.threeteam.sns.dto;

import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;

public class MusicsDto {
    private Long	id;
    private Long	board;
    private Long	board_types;
    private Long	url;
    private LocalDateTime	created_at;

    public MusicsDto() {}

    public MusicsDto(Long id, Long board, Long board_types, Long url, LocalDateTime created_at) {
        this.id = id;
        this.board = board;
        this.board_types = board_types;
        this.url = url;
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

    public long getUrl() {
        return url;
    }

    public void setUrl(long url) {
        this.url = url;
    }

    public LocalDateTime getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, board, board_types, url, created_at);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MusicsDto other = (MusicsDto) obj;
        return Objects.equals(id, other.id) && Objects.equals(board, other.board) && Objects.equals(board_types, other.board_types) && Objects.equals(url, other.url) && Objects.equals(created_at, other.created_at);
    }

    @Override
    public String toString() {
        return "MusicsDto [id=" + id + ", board=" + board + ", board_types=" + board_types + ", url=" + url + ", created_at=" + created_at + "]";
    }
}

