package com.threeteam.sns.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.threeteam.sns.dto.CommunitiesDto;

@Mapper
public interface CommunitiesMapper {
	List<CommunitiesDto> getAll();
	List<CommunitiesDto> getAll(int category, int offset, int limit);

	CommunitiesDto getById(int id);
	List<CommunitiesDto> getByUser(String user, int category, int offset, int limit);
    List<CommunitiesDto> getByFollowees(Map<String, Object> params);
	
	int insert(CommunitiesDto dto);

	void update(CommunitiesDto dto);

	void delete(int id);

	List<CommunitiesDto> search(CommunitiesDto dto);
	
	List<Map<String, Object>> searchList(CommunitiesDto dto);
	
}
