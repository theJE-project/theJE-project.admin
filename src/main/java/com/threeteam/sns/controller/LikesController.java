package com.threeteam.sns.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threeteam.sns.dto.LikesDto;
import com.threeteam.sns.service.LikesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/likes", produces = "application/json; charset=UTF-8")
public class LikesController {
	
	private final LikesService service;
	
	@GetMapping
	public List<LikesDto> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<LikesDto> getById(@PathVariable("id") int id) {
        LikesDto dto = service.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
    public ResponseEntity<String> create(@RequestBody LikesDto dto) {
		service.insert(dto);
        return ResponseEntity.ok("좋아요가 등록되었습니다.");
	}
	
	@PutMapping
    public ResponseEntity<Void> update(@RequestBody LikesDto dto) {
        service.update(dto);
        return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/search")
	public List<LikesDto> search(@RequestBody LikesDto dto) {
		return service.search(dto);
	}
	
	@PostMapping("/count")
	public List<LikesDto> count(@RequestBody LikesDto dto) {
		return service.count(dto);
	}
	
}
