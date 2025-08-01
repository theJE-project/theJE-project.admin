package com.threeteam.sns.mapper;

import com.threeteam.sns.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoriesMapper {
    List<CategoriesDto> getAll();
	CategoriesDto getById(Long id);
}
