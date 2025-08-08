package com.threeteam.sns.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.threeteam.sns.dto.*;
import com.threeteam.sns.mapper.*;
import java.util.List
;
@Service
@RequiredArgsConstructor
public class CategoriesService {

	private final CategoriesMapper mapper;

	public List<CategoriesDto> getAll() {
		return mapper.getAll();
	}

	public CategoriesDto getById(int id) {
		return mapper.getById(id);
	}

	public int insert(CategoriesDto dto) {
		int result = mapper.insert(dto);
		return result;
	}

	public void update(CategoriesDto dto) {
		mapper.update(dto);
	}

	public void delete(int id) {
		mapper.delete(id);
	}

	public List<CategoriesDto> search(CategoriesDto dto) {
		return mapper.search(dto);
	}

}
