package com.threeteam.sns.controller;

import com.threeteam.sns.service.*;
import com.threeteam.sns.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/communities")
public class CommunitiesController {
	
	@Autowired
	private CommunitiesService service;
	@Autowired
	private ImagesService images;
	@Autowired
	private MusicsService musics;
	@Autowired
	private UsersService users;
	@Autowired
	private TracksService tracks;
	@Autowired
	private FollowersService followers;

	@GetMapping("/{id}")
    public ResponseEntity<CommunitiesDto> getById(@PathVariable("/{id}") Long id) {
        CommunitiesDto dto = service.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
	}

	@GetMapping //전체검색
	public ResponseEntity<List<CommunitiesResponsDto>> getAll(
			@RequestParam("category") Long category,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size
	) {
		List<CommunitiesDto> dtos = service.getAll(category, page * size, size);
		List<CommunitiesResponsDto> result = new ArrayList<>();
		for (CommunitiesDto dto : dtos) {
			UsersDto getUser = users.getById(dto.getUsers());
			List<MusicsDto> getMusic = musics.getByBroads(1L, dto.getId());
			List<TracksDto> track = new ArrayList<>();
			for (MusicsDto music : getMusic) {
				track.add(tracks.searchId(music.getUrl()));
			}
			result.add(new CommunitiesResponsDto(
					dto,
					new UsersResponsDto(getUser),
					images.getByBroads(1L, dto.getId()),
					track
			));
		}

		return result != null && !result.isEmpty()
				? ResponseEntity.ok(result)
				: ResponseEntity.notFound().build();
	}


	@GetMapping("/byUser") //전체검색
	public ResponseEntity<List<CommunitiesResponsDto>> getAllByUser(
			@RequestParam("category") Long category,
			@RequestParam(value = "user", required = false) String myId, // 내 아이디
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size
	) {
		List<CommunitiesDto> dtos = service.getAll(category, page * size, size);
		List<CommunitiesResponsDto> result = new ArrayList<>();
		for (CommunitiesDto dto : dtos) {
			UsersDto getUser = users.getById(dto.getUsers());

			// is_following 값 세팅 (내가 작성자 팔로우 중이면 true)
			boolean isFollowing = false;
			if (myId != null && !myId.equals(getUser.getId())) {
				isFollowing = followers.isFollowing(myId, getUser.getId());
			}

			result.add(new CommunitiesResponsDto(
					dto,
					new UsersResponsDto(getUser, isFollowing), // <- 여기에 is_following 값 전달
					images.getByBroads(1L, dto.getId()),
					// music, tracks 등 원래 코드 그대로
					new ArrayList<>()
			));
		}
		return !result.isEmpty() ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
	}


	@GetMapping("/followee") // 팔로잉 검색
	public ResponseEntity<List<CommunitiesResponsDto>> getByFollowee(
			@RequestParam("user") String user,
			@RequestParam("category") Long category,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size
	) {
		// 1. 팔로잉한 사람들의 ID 리스트 가져오기
		List<FollowersDto> followerList = followers.getFolloweesByUser(user);
		// FollowersDto에서 팔로잉 대상(followee) ID만 뽑기
		List<String> followeeIds = followerList.stream()
				.map(FollowersDto::getFollowee)
				.collect(Collectors.toList());

		if(followeeIds.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		// 2. 한 번에 팔로잉한 사람들의 게시물 최신순으로 페이징해서 가져오기
		List<CommunitiesDto> dtos = service.getByFollowees(followeeIds, category, page * size, size);
		List<CommunitiesResponsDto> result = new ArrayList<>();
		for(CommunitiesDto dto : dtos){
			UsersDto getUser = users.getById(dto.getUsers());
			List<MusicsDto> getMusic= musics.getByBroads(1L,dto.getId());
			List<TracksDto> track = new ArrayList<>();
			for(MusicsDto music : getMusic) {
				track.add(tracks.searchId(music.getUrl()));
			}
			result.add(new CommunitiesResponsDto(
					dto,
					new UsersResponsDto(getUser),
					images.getByBroads(1L, dto.getId()),
					track
			));
		}
		return !result.isEmpty() ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
	}

	@GetMapping("/user") // 유저아이디 검색
	public ResponseEntity<List<CommunitiesResponsDto>> getByUser(
			@RequestParam("user") String user,
			@RequestParam("category") Long category,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size
	) {
		List<CommunitiesDto> dtos = service.getByUser(user, category, page * size, size);
		List<CommunitiesResponsDto> result = new ArrayList<>();
		for(CommunitiesDto dto : dtos){
			UsersDto getUser = users.getById(dto.getUsers());
			List<MusicsDto> getMusic= musics.getByBroads(1L,dto.getId());
			List<TracksDto> track = new ArrayList<>();
			for(MusicsDto music : getMusic) {
				track.add(tracks.searchId(music.getUrl()));
			}
			result.add( new CommunitiesResponsDto(
					dto,
					new UsersResponsDto(getUser),
					images.getByBroads(1L, dto.getId()),
					track
			));
		}
		return result != null && !result.isEmpty() ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
	}

	@PostMapping
    public ResponseEntity<Void> create(@RequestBody CommunitiesDto dto) {
		Long id = service.insert(dto);
		if (dto.getImages() != null) {
			for (ImagesDto image : dto.getImages()) {
				image.setBoard(id);
				image.setBoardTypes(1L);
				images.insert(image);
			}
		}
		if(dto.getMusics() != null){
			for (MusicsDto music : dto.getMusics()){
				music.setBoard(id);
				music.setBoardTypes(1L);
				musics.insert(music);
			}
		}
        return ResponseEntity.ok().build();
	}

	@PutMapping
    public ResponseEntity<Void> update(@RequestBody CommunitiesDto dto) {
        service.update(dto);
        return ResponseEntity.ok().build();
	}

	// 게시글 삭제
	@PutMapping("/{id}")
	public ResponseEntity<Void> isDelete(@PathVariable Long id){
		service.isDelete(id);
		return ResponseEntity.ok().build();
	}
	
//	@DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        service.delete(id);
//        return ResponseEntity.noContent().build();
//	}
	
}
