package com.threeteam.sns.dto;

import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;

public class NotificationsDto {
    private Long	id;
    private Long	sender;
    private Long	receiver;
    private Long	board;
    private Long	board_types;
    private String	content;
    private LocalDateTime	created_at;
    private Long	is_read;
    private Long	is_delete;

    public NotificationsDto() {}

    public NotificationsDto(Long id, Long sender, Long receiver, Long board, Long board_types, String content, LocalDateTime created_at, Long is_read, Long is_delete) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.board = board;
        this.board_types = board_types;
        this.content = content;
        this.created_at = created_at;
        this.is_read = is_read;
        this.is_delete = is_delete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
    }

    public Long getReceiver() {
        return receiver;
    }

    public void setReceiver(Long receiver) {
        this.receiver = receiver;
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

    public Long getIsRead() {
        return is_read;
    }

    public void setIsRead(Long is_read) {
        this.is_read = is_read;
    }

    public Long getIsDelete() {
        return is_delete;
    }

    public void setIsDelete(Long is_delete) {
        this.is_delete = is_delete;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sender, receiver, board, board_types, content, created_at, is_read, is_delete);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NotificationsDto other = (NotificationsDto) obj;
        return Objects.equals(id, other.id) && Objects.equals(sender, other.sender) && Objects.equals(receiver, other.receiver) && Objects.equals(board, other.board) && Objects.equals(board_types, other.board_types) && Objects.equals(content, other.content) && Objects.equals(created_at, other.created_at) && Objects.equals(is_read, other.is_read) && Objects.equals(is_delete, other.is_delete);
    }

    @Override
    public String toString() {
        return "NotificationsDto [id=" + id + ", sender=" + sender + ", receiver=" + receiver + ", board=" + board + ", board_types=" + board_types + ", content=" + content + ", created_at=" + created_at + ", is_read=" + is_read + ", is_delete=" + is_delete + "]";
    }
}

