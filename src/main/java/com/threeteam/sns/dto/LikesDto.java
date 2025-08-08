package com.threeteam.sns.dto;

import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class LikesDto {
    private Integer	id;
    private String	users;
    private Integer	board;
    private Integer	board_types;
    private LocalDateTime	created_at;
    private LocalDateTime	updated_at;
    
    private Integer count;
    private Boolean liked;

}

