package com.threeteam.sns.service;

import java.util.List
;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.threeteam.sns.dto.CommentsDto;
import com.threeteam.sns.dto.CommunitiesDto;
import com.threeteam.sns.dto.NotificationsDto;
import com.threeteam.sns.dto.UsersDto;
import com.threeteam.sns.mapper.CommentsMapper;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class CommentsService {

	private final CommentsMapper mapper;
	private final UsersService usersService;
	private final CommunitiesService communitiesService;
	private final NotificationsService notificationsService;
	
	public List<CommentsDto> getAll() {
		return mapper.getAll();
	}

	public CommentsDto getById(int id) {
		return mapper.getById(id);
	}

	public int insert(CommentsDto dto) {
		int result = 0;
	    try {
	        // 1. 원 게시글 여부 확인
	        CommunitiesDto communitiesDto = communitiesService.getById(dto.getBoard());
	        if (communitiesDto == null) {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "댓글 달 원 게시글이 존재하지 않습니다. ID: " + dto.getBoard());
	        }
	        
	        // 2. 댓글 사용자 정보 가져오기
	        UsersDto usersDto = usersService.getById(dto.getUsers());
	        if (usersDto == null) {
	        	throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 사용자 입니다.");
	        }
	        
	        // 댓글 작성
	        result = mapper.insert(dto);
	        if (result == 0) {
	            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "댓글 등록에 실패했습니다.");
	        }
	        
	        CommentsDto commentsDto = null;
	        if (dto.getParent() != null) {	// 원글이 댓글일 때
	        	commentsDto = getById(dto.getParent());
	        }
	        
	        // 알림 작성 - 원 게시글 및 원 댓글 작성자가 아닐경우만 알림 - 원 글에게 알림 전달
//	        if (!dto.getUsers().equals(communitiesDto.getUsers()) || commentsDto == null) {	// 원 댓글 작성자가 다를떄
//	            NotificationsDto notificationsDto = new NotificationsDto();
//	            notificationsDto.setSender(usersDto.getId());					// 보내는이
//	            if (commentsDto != null) {	// 원글이 댓글일 때
//	            	notificationsDto.setReceiver(commentsDto.getUsers());		// 받는이 댓글작성자에게
//	            } else {
//	            	notificationsDto.setReceiver(communitiesDto.getUsers());	// 받는이	 원 게시글작성자에게
//	            }
//	            notificationsDto.setBoard(communitiesDto.getId());				// 원 게시글
//	            notificationsDto.setBoard_types(1);								// 원 게시글 테이블 명	// board_types - 1 communities 2 notifications 3 comments 4 likes
//	            notificationsDto.setContent("\"" + dto.getContent() + "\"");	// 댓글 내용
//
//	            int notiResult = notificationsService.insert(notificationsDto);
//	            if (notiResult == 0) {
//		            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "댓글 등록에 실패했습니다.");
//		        }
//	        }
            
            return result;
	    } catch (Exception e) {
	        e.printStackTrace();
	        // 올바른 로그 출력 (System.out.printf로는 {} 안됨)
	        System.out.println("좋아요 insert 중 예외 발생: " + e.getMessage());
	        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "댓글 작성 중 예외 발생: " + e.getMessage());
	    }
	}

	public void update(CommentsDto dto) {
		mapper.update(dto);
	}

	public void delete(int id) {
		mapper.delete(id);
	}

	public List<CommentsDto> search(CommentsDto dto) {
		return mapper.search(dto);
	}

}
