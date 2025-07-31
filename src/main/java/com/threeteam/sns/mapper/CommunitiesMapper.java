package com.threeteam.sns.mapper;

import com.threeteam.sns.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunitiesMapper {
    List<CommunitiesDto> getAll();

	CommunitiesDto getById(Long id);

    void insert(CommunitiesDto dto);

    void update(CommunitiesDto dto);

    void delete(Long id);
}
