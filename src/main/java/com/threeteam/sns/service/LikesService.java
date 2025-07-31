package com.threeteam.sns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threeteam.sns.dto.*;
import com.threeteam.sns.mapper.*;

import java.util.List;
@Service
public class LikesService {

	@Autowired
	private LikesMapper mapper;

    public List<LikesDto> getAll() {
        return mapper.getAll();
    }

    public LikesDto getById(Long id) {
        return mapper.getById(id);
    }

    public void insert(LikesDto dto) {
        mapper.insert(dto);
    }

    public void update(LikesDto dto) {
        mapper.update(dto);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }}
