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

    public Long insert(CommunitiesDto dto) {
        int result = mapper.insert(dto);
        if (result > 0) {
            return dto.getId();
        } else {
            throw new RuntimeException("Insert failed");
        }
    }

    public void update(CommunitiesDto dto) {
        mapper.update(dto);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    //내가 쓴글 조회 추가
    public List<CommunitiesDto> getByUserId(String userId) {
        return mapper.selectByUserId(userId);
    }


    }