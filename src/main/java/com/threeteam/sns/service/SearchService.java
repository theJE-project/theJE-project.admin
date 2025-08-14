package com.threeteam.sns.service;

import java.util.HashMap;
import java.util.List
;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.threeteam.sns.dto.CommunitiesDto;
import com.threeteam.sns.dto.MusicsDto;
import com.threeteam.sns.dto.UsersDto;
import com.threeteam.sns.mapper.CommunitiesMapper;
import com.threeteam.sns.mapper.MusicsMapper;
import com.threeteam.sns.mapper.UsersMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchService {

	private final CommunitiesMapper communitiesMapper;
	private final MusicsMapper musicsMapper;
	private final UsersMapper usersMapper;
	
	public Map<String, List<Map<String, Object>>> search(HashMap<String, Object> paramsMap) {
		if (paramsMap == null || !paramsMap.containsKey("searchStr")) {
	        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "검색어가 존재하지 않습니다.");
	    }
		String searchStr = paramsMap.get("searchStr").toString();
		String follower = paramsMap.get("follower") != null ? paramsMap.get("follower").toString() : null;
		
		// Search - Communities List
		CommunitiesDto communitiesDto = new CommunitiesDto();
		communitiesDto.setTitle(searchStr);
		communitiesDto.setContent(searchStr);
		communitiesDto.setFollower(follower);
		List<Map<String, Object>> communitiesList = communitiesMapper.searchList(communitiesDto);
		
		// Search - hashTag List
		CommunitiesDto hashTagDto = new CommunitiesDto();
		hashTagDto.setHash(searchStr);
		hashTagDto.setFollower(follower);
		List<Map<String, Object>> hashTagList = communitiesMapper.searchList(hashTagDto);
		
		// Search - Users List
		UsersDto usersDto = new UsersDto();
		usersDto.setName(searchStr);
		usersDto.setEmail(searchStr);
		usersDto.setFollower(follower);
		List<Map<String, Object>> userssList = usersMapper.searchList(usersDto);
		if (follower != null) userssList.removeIf(map -> follower.equals(map.get("id"))); // 유저검색시 본인검색시 리스트에서 본인 삭제처리

		for (Map<String, Object> map : communitiesList) {
		//	System.out.println("communitiesList is_following : " + map.get("is_following"));
		}
		for (Map<String, Object> map : hashTagList) {
		//	System.out.println("hashTagList is_following : " + map.get("is_following"));
		}
		for (Map<String, Object> map : userssList) {
		//	System.out.println("userssList is_following : " + map.get("is_following"));
		}
		
		Map<String, List<Map<String, Object>>> returnMap = new HashMap();
		returnMap.put("communities", communitiesList);
		returnMap.put("hashTag", hashTagList);
		returnMap.put("users", userssList);
		
		return returnMap;
	}

}
