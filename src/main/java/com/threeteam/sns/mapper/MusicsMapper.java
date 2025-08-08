package com.threeteam.sns.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.threeteam.sns.dto.MusicsDto;

@Mapper
public interface MusicsMapper {
	List<MusicsDto> getAll();

	MusicsDto getById(int id);

	int insert(MusicsDto dto);

	void update(MusicsDto dto);

	void delete(int id);

	List<MusicsDto> search(MusicsDto dto);
	List<Map<String, Object>> searchList(MusicsDto dto);
	
	List<MusicsDto> getByBoards(@Param("board_type") int board_type, @Param("board") int board);

}
