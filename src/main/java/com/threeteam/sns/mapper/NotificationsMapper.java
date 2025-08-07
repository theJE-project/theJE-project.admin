package com.threeteam.sns.mapper;

import com.threeteam.sns.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NotificationsMapper {
	List<NotificationsDto> getAll();

	NotificationsDto getById(int id);

	int insert(NotificationsDto dto);

	void update(NotificationsDto dto);

	void delete(int id);

	List<NotificationsDto> search(NotificationsDto dto);
	List<NotificationsDto> getListByUsers(NotificationsDto dto);

	void updateAllRead(NotificationsDto dto);
}
