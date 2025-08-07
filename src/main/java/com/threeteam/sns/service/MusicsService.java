package com.threeteam.sns.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import com.threeteam.sns.dto.*;
import com.threeteam.sns.mapper.*;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MusicsService {

	private final MusicsMapper mapper;

	public List<MusicsDto> getAll() {
		return mapper.getAll();
	}

	public MusicsDto getById(int id) {
		return mapper.getById(id);
	}

	public int insert(MusicsDto dto) {
		int result = mapper.insert(dto);
		return result;
	}

	public void update(MusicsDto dto) {
		mapper.update(dto);
	}

	public void delete(int id) {
		mapper.delete(id);
	}

	public List<MusicsDto> search(MusicsDto dto) {
		return mapper.search(dto);
	}

	public List<Map<String, Object>> searchList(MusicsDto dto) {
		return mapper.searchList(dto);
	}
	
	public List<MusicsDto> getByBoards(int board_type, int board) {
		return  mapper.getByBoards(board_type, board);
	}

}
