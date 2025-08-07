package com.threeteam.sns.dto;

import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class BoardTypesDto {
    private String	id;
    private String	name;
    private LocalDateTime	created_at;
    private LocalDateTime	updated_at;

}

