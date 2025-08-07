package com.threeteam.sns.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.threeteam.sns.dto.*;
import com.threeteam.sns.service.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/communities", produces = "application/json; charset=UTF-8")
public class CommunitiesController {
	
	private final CommunitiesService service;
	private final ImagesService images;
	private final MusicsService musics;
	private final UsersService users;
	private final TracksService tracks;
	private final FollowersService followers;
	
	/*
	@GetMapping
	public List<CommunitiesDto> getAll() {
		return service.getAll();
	}
	*/
	
	@GetMapping("/{id}")
    public ResponseEntity<CommunitiesDto> getById(@PathVariable("id") int id) {
        CommunitiesDto dto = service.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
	}

	@GetMapping //전체검색
	public ResponseEntity<List<CommunitiesResponsDto>> getAll(
			@RequestParam("category") int category,
		    @RequestParam(value = "page", defaultValue = "0") int page,
		    @RequestParam(value = "size", defaultValue = "10") int size
	) {
		System.out.println("communities getAll - category : " + category);
		System.out.println("communities getAll - page : " + page);
		System.out.println("communities getAll - size : " + size);
		List<CommunitiesDto> dtos = service.getAll(category, page * size, size);
		List<CommunitiesResponsDto> result = new ArrayList<>();
		for (CommunitiesDto dto : dtos) {
			System.out.println("dto : " + dto.toString());
			UsersDto getUser = users.getById(dto.getUsers());
			List<MusicsDto> getMusic = musics.getByBoards(1, dto.getId());
			List<TracksDto> track = new ArrayList<>();
			for (MusicsDto music : getMusic) {
				track.add(tracks.searchId(music.getUrl()));
			}
			result.add(new CommunitiesResponsDto(
					dto,
					new UsersResponsDto(getUser),
					images.getByBoards(1, dto.getId()),
					track
			));
		}

		return result != null && !result.isEmpty()
				? ResponseEntity.ok(result)
				: ResponseEntity.notFound().build();
	}

	@GetMapping("/followee") // 팔로잉 검색
	public ResponseEntity<List<CommunitiesResponsDto>> getByFollowee(
			@RequestParam("user") String user,
			@RequestParam("category") int category,
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
			List<MusicsDto> getMusic= musics.getByBoards(1, dto.getId());
			List<TracksDto> track = new ArrayList<>();
			for(MusicsDto music : getMusic) {
				track.add(tracks.searchId(music.getUrl()));
			}
			result.add(new CommunitiesResponsDto(
					dto,
					new UsersResponsDto(getUser),
					images.getByBoards(1, dto.getId()),
					track
			));
		}
		return !result.isEmpty() ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
	}

	@GetMapping("/user") // 유저아이디 검색
	public ResponseEntity<List<CommunitiesResponsDto>> getByUser(
			@RequestParam("user") String user,
			@RequestParam("category") int category,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size
	) {
		List<CommunitiesDto> dtos = service.getByUser(user, category, page * size, size);
		List<CommunitiesResponsDto> result = new ArrayList<>();
		for(CommunitiesDto dto : dtos){
			UsersDto getUser = users.getById(dto.getUsers());
			List<MusicsDto> getMusic= musics.getByBoards(1, dto.getId());
			List<TracksDto> track = new ArrayList<>();
			for(MusicsDto music : getMusic) {
				track.add(tracks.searchId(music.getUrl()));
			}
			result.add( new CommunitiesResponsDto(
					dto,
					new UsersResponsDto(getUser),
					images.getByBoards(1, dto.getId()),
					track
			));
		}
		return result != null && !result.isEmpty() ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
	}

	@PostMapping
    public ResponseEntity<Void> create(@RequestBody CommunitiesDto dto) {
        int id = service.insert(dto);
		if (dto.getImages() != null) {
			for (ImagesDto image : dto.getImages()) {
				image.setBoard(id);
				image.setBoard_types(1);
				images.insert(image);
			}
		}
		if(dto.getMusics() != null){
			for (MusicsDto music : dto.getMusics()){
				music.setBoard(id);
				music.setBoard_types(1);
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
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/search")
	public List<CommunitiesDto> search(@RequestBody CommunitiesDto dto) {
		return service.search(dto);
	}
	
}
