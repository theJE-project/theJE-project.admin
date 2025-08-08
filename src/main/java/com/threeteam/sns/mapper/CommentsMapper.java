package com.threeteam.sns.mapper;

import com.threeteam.sns.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentsMapper {
	List<CommentsDto> getAll();

	CommentsDto getById(int id);

	int insert(CommentsDto dto);

	void update(CommentsDto dto);

	void delete(int id);

	List<CommentsDto> search(CommentsDto dto);

}
