package com.threeteam.sns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threeteam.sns.dto.*;
import com.threeteam.sns.mapper.*;

import java.util.List;
@Service
public class FollowersService {

	@Autowired
	private FollowersMapper mapper;

    public List<FollowersDto> getAll() {
        return mapper.getAll();
    }

    public FollowersDto getById(Long id) {
        return mapper.getById(id);
    }

    public void insert(FollowersDto dto) {
        mapper.insert(dto);
    }

    public void update(FollowersDto dto) {
        mapper.update(dto);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }

    public List<FollowersDto> getFolloweesByUser(String id) { return mapper.getFolloweesByUser(id); }

    public List<FollowersDto> getFollowersByUser(String id) { return  mapper.getFollowersByUser(id); }
}

