package com.threeteam.sns.mapper;

import com.threeteam.sns.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MusicsMapper {
    List<MusicsDto> getAll();

	MusicsDto getById(Long id);

    void insert(MusicsDto dto);

    void update(MusicsDto dto);

    void delete(Long id);
}
