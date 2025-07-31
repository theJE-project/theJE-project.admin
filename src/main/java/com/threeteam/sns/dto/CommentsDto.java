package com.threeteam.sns.dto;

import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;

public class CommentsDto {
    private Long	id;
    private Long	parent;
    private Long	users;
    private Long	board;
    private Long	board_types;
    private String	content;
    private LocalDateTime	created_at;
    private LocalDateTime	updated_at;
    private Long	is_delete;

    public CommentsDto() {}

    public CommentsDto(Long id, Long parent, Long users, Long board, Long board_types, String content, LocalDateTime created_at, LocalDateTime updated_at, Long is_delete) {
        this.id = id;
        this.parent = parent;
        this.users = users;
        this.board = board;
        this.board_types = board_types;
        this.content = content;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.is_delete = is_delete;
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

    public Long getUsers() {
        return users;
    }

    public void setUsers(Long users) {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Long getIsDelete() {
        return is_delete;
    }

    public void setIsDelete(Long is_delete) {
        this.is_delete = is_delete;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parent, users, board, board_types, content, created_at, updated_at, is_delete);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CommentsDto other = (CommentsDto) obj;
        return Objects.equals(id, other.id) && Objects.equals(parent, other.parent) && Objects.equals(users, other.users) && Objects.equals(board, other.board) && Objects.equals(board_types, other.board_types) && Objects.equals(content, other.content) && Objects.equals(created_at, other.created_at) && Objects.equals(updated_at, other.updated_at) && Objects.equals(is_delete, other.is_delete);
    }

    @Override
    public String toString() {
        return "CommentsDto [id=" + id + ", parent=" + parent + ", users=" + users + ", board=" + board + ", board_types=" + board_types + ", content=" + content + ", created_at=" + created_at + ", updated_at=" + updated_at + ", is_delete=" + is_delete + "]";
    }
}

