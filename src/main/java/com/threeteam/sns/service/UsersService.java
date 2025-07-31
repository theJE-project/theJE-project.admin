package com.threeteam.sns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threeteam.sns.dto.*;
import com.threeteam.sns.mapper.*;

import java.util.List;
@Service
public class UsersService {

	@Autowired
	private UsersMapper mapper;

    public List<UsersDto> getAll() {
        return mapper.getAll();
    }

    public UsersDto getById(Long id) {
        return mapper.getById(id);
    }

    public void insert(UsersDto dto) {
        mapper.insert(dto);
    }

    public void update(UsersDto dto) {
        mapper.update(dto);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }}
