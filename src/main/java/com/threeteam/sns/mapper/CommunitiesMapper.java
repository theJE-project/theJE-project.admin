package com.threeteam.sns.mapper;

import com.threeteam.sns.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CommunitiesMapper {
    List<CommunitiesDto> getAll(Long category, int offset, int limit);

    CommunitiesDto getById(Long id);

    List<CommunitiesDto> getByUser(String user,Long category,int offset, int limit);

    List<CommunitiesDto> getByFollowees(Map<String, Object> params);

    int insert(CommunitiesDto dto);

    void update(CommunitiesDto dto);

    void delete(Long id);

    //  내가 쓴 글만 조회 (userId로)
    List<CommunitiesDto> selectByUserId(String userId);


}
