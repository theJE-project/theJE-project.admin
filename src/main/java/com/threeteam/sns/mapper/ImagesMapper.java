package com.threeteam.sns.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.threeteam.sns.dto.ImagesDto;

@Mapper
public interface ImagesMapper {
	List<ImagesDto> getAll();

	ImagesDto getById(int id);

	int insert(ImagesDto dto);

	void update(ImagesDto dto);

	void delete(int id);

	List<ImagesDto> search(ImagesDto dto);

	List<ImagesDto> getByBoards(@Param("board_type") int board_type, @Param("board") int board);
}
