package com.threeteam.sns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threeteam.sns.dto.*;
import com.threeteam.sns.mapper.*;

import java.util.List;
@Service
public class MusicsService {

	@Autowired
	private MusicsMapper mapper;

    public List<MusicsDto> getAll() {
        return mapper.getAll();
    }

    public MusicsDto getById(Long id) {
        return mapper.getById(id);
    }

    public List<MusicsDto> getByBroads(Long board_type,Long board) { return  mapper.getByBroads(board_type,board); }

    public void insert(MusicsDto dto) {
        mapper.insert(dto);
    }

    public void update(MusicsDto dto) {
        mapper.update(dto);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }}
