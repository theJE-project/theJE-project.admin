package com.threeteam.sns.mapper;

import com.threeteam.sns.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LikesMapper {
    List<LikesDto> getAll();

	LikesDto getById(Long id);

    void insert(LikesDto dto);

    void update(LikesDto dto);

    void delete(Long id);
}
