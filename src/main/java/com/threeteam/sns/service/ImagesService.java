package com.threeteam.sns.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.threeteam.sns.dto.*;
import com.threeteam.sns.mapper.*;
import java.util.List
;
@Service
@RequiredArgsConstructor
public class ImagesService {

	private final ImagesMapper mapper;

	public List<ImagesDto> getAll() {
		return mapper.getAll();
	}

	public ImagesDto getById(int id) {
		return mapper.getById(id);
	}

	public int insert(ImagesDto dto) {
		int result = mapper.insert(dto);
		return result;
	}

	public void update(ImagesDto dto) {
		mapper.update(dto);
	}

	public void delete(int id) {
		mapper.delete(id);
	}

	public List<ImagesDto> search(ImagesDto dto) {
		return mapper.search(dto);
	}
	
	public List<ImagesDto> getByBoards(int board_type, int board) {
		return mapper.getByBoards(board_type, board);
	}
	
}
