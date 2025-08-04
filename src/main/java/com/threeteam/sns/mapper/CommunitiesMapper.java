package com.threeteam.sns.mapper;

import com.threeteam.sns.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunitiesMapper {
    List<CommunitiesDto> getAll();

	CommunitiesDto getById(Long id);

    int insert(CommunitiesDto dto);

    void update(CommunitiesDto dto);

    void delete(Long id);

    //  내가 쓴 글만 조회 (userId로)
    List<CommunitiesDto> selectByUserId(String userId);


}
