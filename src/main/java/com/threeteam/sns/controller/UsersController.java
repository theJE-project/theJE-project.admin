package com.threeteam.sns.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import com.threeteam.sns.dto.*;
import com.threeteam.sns.service.UsersService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/users", produces = "application/json; charset=UTF-8")
public class UsersController {
	
	private final UsersService service;
	private final Map<String, UsersPendingDto> pendingUsers = new ConcurrentHashMap<>();
	
	@GetMapping
	public List<UsersDto> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<UsersDto> getById(@PathVariable("id") String id) {
        UsersDto dto = service.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
	}

	@PostMapping // 유저 회원 가입
	public ResponseEntity<String> postUsersSignup(@RequestBody UsersDto user) {
		String success = service.registerUser(user);
		if (success == null) {
			return ResponseEntity.ok("회원가입 성공! 이메일 인증을 완료해주세요.");
		} else {
			return ResponseEntity.badRequest().body(success);
		}
	}
	
	@PostMapping("login")
	public ResponseEntity<?> postLogin(@RequestBody UsersDto user) {
		System.out.println(user);
		String success = service.login(user.getAccount(), user.getPassword());
		if(success == null) {
			UsersDto loggedUser = service.getByAccount(user.getAccount());
			Map<String, Object> response = new HashMap<>();
			response.put("id", loggedUser.getId());
			response.put("name", loggedUser.getName());
			return ResponseEntity.ok(response);
		} else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(success);
	}
	
	@PostMapping("/verify") // 이메일 인증 확인
	public ResponseEntity<?> verifyEmail(@RequestBody Map<String, String> body){
		String token = body.get("token");
		UsersDto verifiedUser = service.verifyEmailToken(token);
		if (verifiedUser != null) {
			return ResponseEntity.ok(verifiedUser);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("유효하지 않거나 만료된 토큰입니다.");
	}
	
	/*
	@PostMapping
    public ResponseEntity<Void> create(@RequestBody UsersDto dto) {
        service.insert(dto);
        return ResponseEntity.ok().build();
	}
	*/
	
	@PutMapping
    public ResponseEntity<Void> update(@RequestBody UsersDto dto) {
        service.update(dto);
        return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/search")
	public List<UsersDto> search(@RequestBody UsersDto dto) {
		return service.search(dto);
	}
	
	// 추가
	@GetMapping("/my")
	public ResponseEntity<UsersResponsDto> getMyUser(@RequestParam("userId") String userId) {
		System.out.println("🔍 요청받은 userId = " + userId);  // userId 값 확인

		UsersDto dto = service.getById(userId);

		System.out.println("📦 조회된 UsersDto = " + dto); // dt
		if (dto == null) {
			return ResponseEntity.notFound().build();
		}
		UsersResponsDto response = new UsersResponsDto(dto);
		return ResponseEntity.ok(response);
	}

	@Scheduled(fixedRate = 5 * 60 * 1000) // 5분마다 실행
	public void clearExpiredTokens() {
		long now = System.currentTimeMillis();
		long expiration = 20 * 60 * 1000; // 20분
		pendingUsers.entrySet().removeIf(entry ->
				now - entry.getValue().getCreate_at() > expiration
		);
	}
	
}
