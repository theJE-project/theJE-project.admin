package com.threeteam.sns.mapper;

import com.threeteam.sns.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FollowersMapper {
    List<FollowersDto> getAll();

	FollowersDto getById(Long id);

    void insert(FollowersDto dto);

    void update(FollowersDto dto);

    void delete(Long id);

    List<FollowersDto> getFolloweesByUser(String id);

    List<FollowersDto> getFollowersByUser(String id);
}
