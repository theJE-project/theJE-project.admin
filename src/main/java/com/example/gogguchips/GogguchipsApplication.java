package com.example.gogguchips;

import com.example.gogguchips.api.Track.TrackData;
import com.example.gogguchips.api.users.UsersData;
import com.example.gogguchips.api.users.UsersService;
import com.example.gogguchips.api.users.PendingUserData;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import com.example.gogguchips.api.categories.categories;
import com.example.gogguchips.api.categories.categoriesData;
import org.springframework.http.HttpStatus;
import com.example.gogguchips.api.Track.TrackService;

@SpringBootApplication
@EnableScheduling
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
	@RequestMapping("/api/deezer")
	@CrossOrigin(origins = "http://localhost:5173")
	public class DeezerController {
		@Autowired
		private TrackService service;
		@GetMapping("/search")
		public List<TrackData> search(@RequestParam String q) {
			return service.searchTracks(q);
		}

	}

	@RestController
	@RequestMapping("/api/users")
	@CrossOrigin(origins = "http://localhost:5173")
	static class UsersController {
		@Autowired
		private UsersService usersService;
		private final Map<String, PendingUserData> pendingUsers = new ConcurrentHashMap<>();

		@GetMapping("") // 유저 조회
		public ResponseEntity<?> getUserById(@RequestParam("id") String id) {
			UsersData user = usersService.findById(id);
			System.out.println(user);
			if (user != null) {
				return ResponseEntity.ok(user);
			}
			return ResponseEntity.notFound().build();
		}

		@PostMapping("") // 유저 회원 가입
		public ResponseEntity<String> postUsersSignup(@RequestBody UsersData user) {
			String success = usersService.registerUser(user);
			if (success == null) {
				return ResponseEntity.ok("회원가입 성공! 이메일 인증을 완료해주세요.");
			} else {
				return ResponseEntity.badRequest().body(success);
			}
		}

		@PostMapping("login")
		public ResponseEntity<?> postLogin(@RequestBody UsersData user) {
			System.out.println(user);
			String success = usersService.login(user.getAccount(),user.getPassword());
			if(success == null) {
				UsersData loggedUser = usersService.findByAccount(user.getAccount());
				Map<String, Object> response = new HashMap<>();
				response.put("id", loggedUser.getId());
				response.put("name", loggedUser.getName());
				return ResponseEntity.ok(response);
			} else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(success);
		}

		@PostMapping("/verify") // 이메일 인증 확인
		public ResponseEntity<?> verifyEmail(@RequestBody Map<String, String> body){
			String token = body.get("token");
			UsersData verifiedUser = usersService.verifyEmailToken(token);
			if (verifiedUser != null) {
				return ResponseEntity.ok(verifiedUser);
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("유효하지 않거나 만료된 토큰입니다.");
		}

		@Scheduled(fixedRate = 5 * 60 * 1000) // 5분마다 실행
		public void clearExpiredTokens() {
			long now = System.currentTimeMillis();
			long expiration = 20 * 60 * 1000; // 20분
			pendingUsers.entrySet().removeIf(entry ->
					now - entry.getValue().getCreatedAt() > expiration
			);
		}
	}
}
