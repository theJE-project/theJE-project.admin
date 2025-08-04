package com.threeteam.sns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threeteam.sns.dto.*;
import com.threeteam.sns.mapper.*;

import java.util.List;
@Service
public class ImagesService {

	@Autowired
	private ImagesMapper mapper;

    public List<ImagesDto> getAll() {
        return mapper.getAll();
    }

    public ImagesDto getById(Long id) {
        return mapper.getById(id);
    }

    public List<ImagesDto> getByBroads(Long board_type,Long board) { return mapper.getByBroads(board_type,board); }

    public void insert(ImagesDto dto) {
        mapper.insert(dto);
    }

    public void update(ImagesDto dto) {
        mapper.update(dto);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }}
