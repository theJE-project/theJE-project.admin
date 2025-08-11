package com.threeteam.sns.service;

import lombok.RequiredArgsConstructor;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Bool;
import org.springframework.stereotype.Service;
import com.threeteam.sns.dto.*;
import com.threeteam.sns.mapper.*;

import java.util.HashMap;
import java.util.List
;
import java.util.Map;
@Service
@RequiredArgsConstructor
public class CommunitiesService {

	private final CommunitiesMapper mapper;

	public List<CommunitiesDto> getAll(int category, int offset, int limit, Boolean isVisible) {
        return mapper.getAll(category, offset, limit, isVisible);
    }

	public CommunitiesDto getById(int id) {
		return mapper.getById(id);
	}
	public List<CommunitiesDto> getByUser(String user, int category, int offset, int limit) {
        return  mapper.getByUser(user, category, offset, limit);
    }
    public List<CommunitiesDto> getByFollowees(List<String> followee, int category, int offset, int limit) {
        Map<String, Object> params = new HashMap<>();
        params.put("followee", followee);
        params.put("category", category);
        params.put("offset", offset);
        params.put("limit", limit);
        return mapper.getByFollowees(params);
    }

	public int insert(CommunitiesDto dto) {
		mapper.insert(dto);
		return dto.getId();
	}

	public void update(CommunitiesDto dto) {
		mapper.update(dto);
	}

	public void updateView(int id) {
		mapper.updateView(id);
	}

	// 게시글 삭제
	public void isDelete(int id){
		mapper.isDelete(id);
	}

	public void delete(int id) {
		mapper.delete(id);
	}

	public List<CommunitiesDto> search(CommunitiesDto dto) {
		return mapper.search(dto);
	}
	
	public List<Map<String, Object>> searchList(CommunitiesDto dto) {
		return mapper.searchList(dto);
	}

	//내가 쓴글 조회 추가
	public List<CommunitiesDto> getByUserId(String userId) {
		return mapper.selectByUserId(userId);
	}

}
