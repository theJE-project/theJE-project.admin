package com.threeteam.sns.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.threeteam.sns.dto.*;
import com.threeteam.sns.mapper.*;
import java.util.List
;
@Service
@RequiredArgsConstructor
public class NotificationsService {

	private final NotificationsMapper mapper;

	public List<NotificationsDto> getAll() {
		return mapper.getAll();
	}

	public  List<NotificationsDto> getById(String id) {
		return mapper.getById(id);
	}

	public int insert(NotificationsDto dto) {
		int result = mapper.insert(dto);
		return result;
	}

	public void update(NotificationsDto dto) {
		mapper.update(dto);
	}
	
	public void delete(int id) {
		mapper.delete(id);
	}

	public List<NotificationsDto> search(NotificationsDto dto) {
		return mapper.search(dto);
	}
	
	public List<NotificationsDto> getListByUsers(NotificationsDto dto) {
		return mapper.search(dto);
	}
	
	public void updateAllRead(NotificationsDto dto) {
		mapper.updateAllRead(dto);
	}

}
