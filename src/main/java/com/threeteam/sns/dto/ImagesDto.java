package com.threeteam.sns.dto;

import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class ImagesDto {
    private Integer	id;
    private Integer	board;
    private Integer	board_types;
    private String	url;
    private Boolean	is_main = true;
    private LocalDateTime	created_at;
    private LocalDateTime	updated_at;

}

