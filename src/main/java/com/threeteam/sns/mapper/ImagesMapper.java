package com.threeteam.sns.mapper;

import com.threeteam.sns.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImagesMapper {
    List<ImagesDto> getAll();

	ImagesDto getById(Long id);

    void insert(ImagesDto dto);

    void update(ImagesDto dto);

    void delete(Long id);
}
