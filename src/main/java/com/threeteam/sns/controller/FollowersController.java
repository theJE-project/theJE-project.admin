package com.threeteam.sns.controller;

import com.threeteam.sns.service.*;
import com.threeteam.sns.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/followers")
public class FollowersController {
	
	@Autowired
	private FollowersService service  = new FollowersService();
	@Autowired
	private UsersService users;
	
	@GetMapping
	public List<FollowersDto> getAll() {
		return service.getAll();
	}

	@GetMapping("/followee/{id}")
	public ResponseEntity<List<UsersResponsDto>> getById(@PathVariable("id") String id) {
		List<FollowersDto> dto = service.getFolloweesByUser(id);
		List<UsersResponsDto> result = new ArrayList<>();
		for (FollowersDto followersDto : dto) {
			result.add(new UsersResponsDto(users.getById(followersDto.getFollowee())));
		}
		return !result.isEmpty() ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
	}

	@GetMapping("/follower/{id}")
	public ResponseEntity<List<UsersResponsDto>> getFollowers(@PathVariable("id") String id) {
		List<FollowersDto> dto = service.getFollowersByUser(id);
		List<UsersResponsDto> result = new ArrayList<>();
		for (FollowersDto followersDto : dto) {
			result.add(new UsersResponsDto(users.getById(followersDto.getFollower())));
		}
		return !result.isEmpty() ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
	}
//
//	@GetMapping("/following/{id}")
//	public ResponseEntity<List<UsersResponsDto>> getIsFollowingByUser(@PathVariable String id){
//		List<FollowersDto> dto = service.getIsFollowingByUser(id);
//		List<UsersResponsDto> result = new ArrayList<>();
//		for (FollowersDto followersDto : dto){
//			result.add(new UsersResponsDto(users.getById(followersDto.getFollowee())));
//		}
//		return !result.isEmpty() ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
//	}

	@GetMapping("/is-following")
	public ResponseEntity<Boolean> isFollowing(
			@RequestParam String myId,
			@RequestParam String targetId
	) {
		boolean result = service.isFollowing(myId, targetId);
		return ResponseEntity.ok(result);
	}


	@PostMapping
    public ResponseEntity<Void> create(@RequestBody FollowersDto dto) {
        service.insert(dto);
        return ResponseEntity.ok().build();
	}
	
	@PutMapping
    public ResponseEntity<Void> update(@RequestBody FollowersDto dto) {
        service.update(dto);
        return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("/{id}") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Void> deleteFollowing(
			@RequestParam String follower,
			@RequestParam String followee
	) {
		service.deleteFollowing(follower, followee);
		return ResponseEntity.noContent().build();
	}

}
