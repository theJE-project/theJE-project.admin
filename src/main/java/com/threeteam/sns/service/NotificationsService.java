package com.threeteam.sns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threeteam.sns.dto.*;
import com.threeteam.sns.mapper.*;

import java.util.List;
@Service
public class NotificationsService {

	@Autowired
	private NotificationsMapper mapper;

    public List<NotificationsDto> getAll() {
        return mapper.getAll();
    }

    public NotificationsDto getById(Long id) {
        return mapper.getById(id);
    }

    public void insert(NotificationsDto dto) {
        mapper.insert(dto);
    }

    public void update(NotificationsDto dto) {
        mapper.update(dto);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }}
