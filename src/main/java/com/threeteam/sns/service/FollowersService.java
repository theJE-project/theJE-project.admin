package com.threeteam.sns.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.threeteam.sns.dto.*;
import com.threeteam.sns.mapper.*;
import java.util.List
;
@Service
@RequiredArgsConstructor
public class FollowersService {

	private final FollowersMapper mapper;

	public List<FollowersDto> getAll() {
		return mapper.getAll();
	}

	public FollowersDto getById(int id) {
		return mapper.getById(id);
	}

	public int insert(FollowersDto dto) {
		int result = mapper.insert(dto);
		return result;
	}

	public void update(FollowersDto dto) {
		mapper.update(dto);
	}

	public void delete(int id) {
		mapper.delete(id);
	}

	public List<FollowersDto> search(FollowersDto dto) {
		return mapper.search(dto);
	}
	
	public List<FollowersDto> getFolloweesByUser(String id) {
		return mapper.getFolloweesByUser(id);
	}

    public List<FollowersDto> getFollowersByUser(String id) {
    	return  mapper.getFollowersByUser(id);
    }

	public boolean isFollowing(String follower, String followee) {
		return mapper.isFollowing(follower, followee);
	}

}
