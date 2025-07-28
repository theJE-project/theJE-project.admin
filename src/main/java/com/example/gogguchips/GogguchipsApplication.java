package com.example.gogguchips;

import com.example.gogguchips.api.users.UsersData;
import com.example.gogguchips.api.users.UsersService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import com.example.gogguchips.api.categories.categories;
import com.example.gogguchips.api.categories.categoriesData;
import org.springframework.http.HttpStatus;

@SpringBootApplication
@MapperScan({
		"com.example.gogguchips.mapper",
		"com.example.gogguchips.api.categories",
		"com.example.gogguchips.api.users"
})

public class GogguchipsApplication {
	public static void main(String[] args) {
		SpringApplication.run(GogguchipsApplication.class, args);
	}
	@RestController
	@RequestMapping("/api/categories")
	@CrossOrigin(origins = "http://localhost:5173")
	static class categroiesController {
		@Autowired
		private categories categroiesMapper;
		@GetMapping("")
		public List<categoriesData> getCategories() {
			return categroiesMapper.allSelect();
		}
	}
	@RestController
	@RequestMapping("/api/users")
	static class UsersController {
		@Autowired
		private UsersService usersService;

		@GetMapping("") // 유저 조회
		public ResponseEntity<?> getUserByAccount(@RequestParam("account") String account) {
			UsersData user = usersService.findByAccount(account);
			if (user != null) {
				return ResponseEntity.ok(user);
			}
			return ResponseEntity.notFound().build();
		}

		@PostMapping("") // 유저 회원 가입
		public ResponseEntity<String> postUsersSignup(@RequestBody UsersData user) {
			boolean success = usersService.registerUser(user);
			if (success) {
				return ResponseEntity.ok("회원가입 성공! 이메일 인증을 완료해주세요.");
			} else {
				return ResponseEntity.badRequest().body("회원가입 실패!");
			}
		}

		@GetMapping("/verify") // 이메일 인증 확인
		public ResponseEntity<?> verifyEmail(@RequestParam String token) {
			UsersData verifiedUser = usersService.verifyEmailToken(token);
			if (verifiedUser != null) {
				return ResponseEntity.ok(verifiedUser);
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("유효하지 않거나 만료된 토큰입니다.");
		}
	}
}
