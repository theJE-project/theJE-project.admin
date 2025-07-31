package com.threeteam.sns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threeteam.sns.dto.*;
import com.threeteam.sns.mapper.*;

import java.util.List;
@Service
public class CategoriesService {

    @Autowired
    private CategoriesMapper mapper;

    public List<CategoriesDto> getAll() {
        return mapper.getAll();
    }

    public CategoriesDto getById(Long id) {
        return mapper.getById(id);
    }
}