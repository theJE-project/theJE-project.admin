package com.threeteam.sns.dto;

import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class CommentsDto {
    private Integer	id;
    private Integer	parent;
    private String	users;
    private Integer	board;
    private Integer	board_types;
    private String	content;
    private LocalDateTime	created_at;
    private LocalDateTime	updated_at;
    private Boolean	is_delete;

}

