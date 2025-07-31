package com.threeteam.sns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threeteam.sns.dto.*;
import com.threeteam.sns.mapper.*;

import java.util.List;
@Service
public class CommentsService {

	@Autowired
	private CommentsMapper mapper;

    public List<CommentsDto> getAll() {
        return mapper.getAll();
    }

    public CommentsDto getById(Long id) {
        return mapper.getById(id);
    }

    public void insert(CommentsDto dto) {
        mapper.insert(dto);
    }

    public void update(CommentsDto dto) {
        mapper.update(dto);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }}
