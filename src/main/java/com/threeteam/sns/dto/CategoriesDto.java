package com.threeteam.sns.dto;

import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class CategoriesDto {
    private Integer	id;
    private Integer	parent;
    private String	name;
    private String	url;
    private Integer	board_type;
    private LocalDateTime	created_at;
    private LocalDateTime	updated_at;

}

