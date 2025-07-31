package com.threeteam.sns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threeteam.sns.dto.*;
import com.threeteam.sns.mapper.*;

import java.util.List;
@Service
public class BoardTypesService {

	@Autowired
	private BoardTypesMapper mapper;

    public List<BoardTypesDto> getAll() {
        return mapper.getAll();
    }

    public BoardTypesDto getById(Long id) {
        return mapper.getById(id);
    }

    public void insert(BoardTypesDto dto) {
        mapper.insert(dto);
    }

    public void update(BoardTypesDto dto) {
        mapper.update(dto);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }}
