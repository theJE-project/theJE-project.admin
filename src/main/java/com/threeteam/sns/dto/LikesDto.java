package com.threeteam.sns.dto;

import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;

public class LikesDto {
    private Long	id;
    private String	users;
    private Long	board;
    private Long	board_types;
    private LocalDateTime	created_at;

    public LikesDto() {}

    public LikesDto(Long id, String users, Long board, Long board_types, LocalDateTime created_at) {
        this.id = id;
        this.users = users;
        this.board = board;
        this.board_types = board_types;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
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

    public LocalDateTime getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, users, board, board_types, created_at);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LikesDto other = (LikesDto) obj;
        return Objects.equals(id, other.id) && Objects.equals(users, other.users) && Objects.equals(board, other.board) && Objects.equals(board_types, other.board_types) && Objects.equals(created_at, other.created_at);
    }

    @Override
    public String toString() {
        return "LikesDto [id=" + id + ", users=" + users + ", board=" + board + ", board_types=" + board_types + ", created_at=" + created_at + "]";
    }
}

