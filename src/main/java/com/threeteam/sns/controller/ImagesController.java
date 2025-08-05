package com.threeteam.sns.controller;

import com.threeteam.sns.service.*;
import com.threeteam.sns.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// [파일업로드추가] import 추가
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/images")
public class ImagesController {

	@Autowired
	private ImagesService service  = new ImagesService();

	@GetMapping
	public List<ImagesDto> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ImagesDto> getById(@PathVariable("/{id}") Long id) {
		ImagesDto dto = service.getById(id);
		return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody ImagesDto dto) {
		service.insert(dto);
		return ResponseEntity.ok().build();
	}

	@PutMapping
	public ResponseEntity<Void> update(@RequestBody ImagesDto dto) {
		service.update(dto);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("/{id}") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	// [파일업로드추가] 프로필/이미지 파일 업로드용 엔드포인트 추가
	@PostMapping("/upload")
	public ResponseEntity<?> uploadProfileImage(@RequestParam("file") MultipartFile file) {
		try {
			// 저장할 폴더 경로 (★ 경로 수정! 프로젝트 루트 uploads 폴더)
			String uploadDir = System.getProperty("user.dir") + "/uploads/"; // ★ 여기만 수정!
			String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
			Path filePath = Paths.get(uploadDir + fileName);
			Files.createDirectories(filePath.getParent());
			file.transferTo(filePath.toFile());

			// URL 생성 (프론트엔드에서 바로 <img src=...> 사용 가능)
			String fileUrl = "/uploads/" + fileName;

			java.util.HashMap<String, String> result = new java.util.HashMap<>();
			result.put("url", fileUrl);
			return ResponseEntity.ok(result);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body("이미지 업로드 실패");
		}
	}
	// [파일업로드추가] 끝

}
