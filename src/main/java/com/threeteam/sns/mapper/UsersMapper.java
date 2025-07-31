package com.threeteam.sns.mapper;

import com.threeteam.sns.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper {
    List<UsersDto> getAll();

	UsersDto getById(Long id);
    UsersDto getByAccount(String account);
    UsersDto getByEmail(String email);

    void insert(UsersDto dto);

    void update(UsersDto dto);

    void delete(Long id);
}
