package com.threeteam.sns.mapper;

import com.threeteam.sns.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardTypesMapper {
	List<BoardTypesDto> getAll();

	BoardTypesDto getById(int id);

	int insert(BoardTypesDto dto);

	void update(BoardTypesDto dto);

	void delete(int id);

	List<BoardTypesDto> search(BoardTypesDto dto);

}
