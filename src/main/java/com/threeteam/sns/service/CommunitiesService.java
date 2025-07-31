package com.threeteam.sns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threeteam.sns.dto.*;
import com.threeteam.sns.mapper.*;

import java.util.List;
@Service
public class CommunitiesService {

	@Autowired
	private CommunitiesMapper mapper;

    public List<CommunitiesDto> getAll() {
        return mapper.getAll();
    }

    public CommunitiesDto getById(Long id) {
        return mapper.getById(id);
    }

    public void insert(CommunitiesDto dto) {
        mapper.insert(dto);
    }

    public void update(CommunitiesDto dto) {
        mapper.update(dto);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }}
