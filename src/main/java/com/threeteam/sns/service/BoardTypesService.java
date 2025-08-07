package com.threeteam.sns.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.threeteam.sns.dto.*;
import com.threeteam.sns.mapper.*;
import java.util.List
;
@Service
@RequiredArgsConstructor
public class BoardTypesService {

	private final BoardTypesMapper mapper;

	public List<BoardTypesDto> getAll() {
		return mapper.getAll();
	}

	public BoardTypesDto getById(int id) {
		return mapper.getById(id);
	}

	public int insert(BoardTypesDto dto) {
		int result = mapper.insert(dto);
		return result;
	}

	public void update(BoardTypesDto dto) {
		mapper.update(dto);
	}

	public void delete(int id) {
		mapper.delete(id);
	}

	public List<BoardTypesDto> search(BoardTypesDto dto) {
		return mapper.search(dto);
	}

}
