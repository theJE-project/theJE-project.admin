package com.threeteam.sns.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.threeteam.sns.dto.CommunitiesDto;
import com.threeteam.sns.dto.UsersDto;

@Mapper
public interface UsersMapper {
	List<UsersDto> getAll();

	UsersDto getById(String id);

	int insert(UsersDto dto);

	void update(UsersDto dto);

	void delete(int id);

	List<UsersDto> search(UsersDto dto);
	List<Map<String, Object>> searchList(UsersDto dto);
	
	UsersDto getByAccount(String account);
    UsersDto getByEmail(String email);

}
