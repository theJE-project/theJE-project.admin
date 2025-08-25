package com.threeteam.sns.service;

import java.util.List
;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.threeteam.sns.dto.CommunitiesDto;
import com.threeteam.sns.dto.LikesDto;
import com.threeteam.sns.dto.NotificationsDto;
import com.threeteam.sns.dto.UsersDto;
import com.threeteam.sns.mapper.LikesMapper;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class LikesService {

	private final LikesMapper mapper;
	private final UsersService usersService;
	private final CommunitiesService communitiesService;
	private final NotificationsService notificationsService;

	public List<LikesDto> getAll() {
		return mapper.getAll();
	}

	public LikesDto getById(int id) {
		return mapper.getById(id);
	}

	@Transactional	// Exception 발생시, 자동 rollback
	public int insert(LikesDto dto) {
		int result = 0;
	    try {
//	        // 1. 좋아요할 게시글 여부 확인
//	        CommunitiesDto communitiesDto = communitiesService.getById(dto.getBoard());
//	        if (communitiesDto == null) {
//	            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "좋아요할 게시글이 존재하지 않습니다. ID: " + dto.getBoard());
//	        }
//	        // 2. 좋아요 했는지 여부 확인
//	        List<LikesDto> existingList = mapper.search(dto);
//	        if (!existingList.isEmpty()) {
//	        	throw new ResponseStatusException(HttpStatus.CONFLICT, "이미 좋아요한 게시글입니다.");
//	        }
//
//	        // 3. 좋아요 누른 사용자 정보 가져오기
//	        UsersDto usersDto = usersService.getById(dto.getUsers());
//	        if (usersDto == null) {
//	        	throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 사용자 입니다.");
//	        }
//	        // 4. 알림은 자기 글이 아닐 경우만 생성
//	        if (!dto.getUsers().equals(communitiesDto.getUsers())) {
//	        	result = mapper.insert(dto);
//		        if (result == 0) {
//		            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "좋아요 등록에 실패했습니다.");
//		        }
//	            NotificationsDto notificationsDto = new NotificationsDto();
//	            notificationsDto.setSender(usersDto.getId());					// 보내는이
//	            notificationsDto.setReceiver(communitiesDto.getUsers());		// 받는이
//	            notificationsDto.setBoard(communitiesDto.getId());				// 원 게시글
//	            notificationsDto.setBoard_types(4);								// 원 게시글 테이블 명	// board_types - 1 communities 2 notifications 3 comments 4 likes
//	            notificationsDto.setContent("\"" + communitiesDto.getTitle() + "\"을(를) 좋아요하였습니다.");
//
//	            int notiResult = notificationsService.insert(notificationsDto);
//	            if (notiResult == 0) {
//		            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "좋아요 등록에 실패했습니다.");
//		        }
//	        }

			result = mapper.insert(dto);
			if (result == 0) {
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "좋아요 등록에 실패했습니다.");
			}
	        return result;
	    } catch (Exception e) {
	        e.printStackTrace();
	        // 올바른 로그 출력 (System.out.printf로는 {} 안됨)
	        System.out.println("좋아요 insert 중 예외 발생: " + e.getMessage());
	        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "좋아요 insert 중 예외 발생: " + e.getMessage());
	    }
	}


	public void update(LikesDto dto) {
		mapper.update(dto);
	}

	public void delete(int id) {
		mapper.delete(id);
	}

	public List<LikesDto> search(LikesDto dto) {
		return mapper.search(dto);
	}
	
	public List<LikesDto> count(LikesDto dto) {
		return mapper.count(dto);
	}

}
