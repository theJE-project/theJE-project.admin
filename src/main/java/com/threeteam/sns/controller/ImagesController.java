package com.threeteam.sns.controller;

import com.threeteam.sns.service.*;
import com.threeteam.sns.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/images", produces = "application/json; charset=UTF-8")
public class ImagesController {

	private final ImagesService service;

	@GetMapping
	public List<ImagesDto> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
    public ResponseEntity<ImagesDto> getById(@PathVariable("id") int id) {
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
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
	}

	@PostMapping("/search")
	public List<ImagesDto> search(@RequestBody ImagesDto dto) {
		return service.search(dto);
	}

	// ✅ 날짜별 폴더에 이미지 업로드
	@PostMapping("/upload")
	public ResponseEntity<?> uploadProfileImage(@RequestParam("file") MultipartFile file) {
		try {
			// 📅 날짜 폴더 생성 (예: /uploads/20250807/)
			String dateFolder = new java.text.SimpleDateFormat("yyyyMMdd").format(new java.util.Date());
			String uploadDir = System.getProperty("user.dir") + "/uploads/" + dateFolder + "/";

			// 🆔 고유한 파일명 생성
			String fileName = java.util.UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
			Path filePath = Paths.get(uploadDir + fileName);

			// 📂 디렉토리 생성 및 저장
			Files.createDirectories(filePath.getParent());
			file.transferTo(filePath.toFile());

			// 🌐 클라이언트에 보낼 URL 경로
			String fileUrl = "/uploads/" + dateFolder + "/" + fileName;

			java.util.HashMap<String, String> result = new java.util.HashMap<>();
			result.put("url", fileUrl);
			return ResponseEntity.ok(result);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body("이미지 업로드 실패");
		}
	}
}
