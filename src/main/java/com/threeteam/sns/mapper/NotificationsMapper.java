package com.threeteam.sns.mapper;

import com.threeteam.sns.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NotificationsMapper {
    List<NotificationsDto> getAll();

	NotificationsDto[] getById(String id);

    void insert(NotificationsDto dto);

    void update(NotificationsDto dto);

    void delete(String id);
}
