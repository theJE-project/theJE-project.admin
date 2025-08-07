package com.threeteam.sns.controller;

import com.threeteam.sns.service.*;
import com.threeteam.sns.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/boardTypes", produces = "application/json; charset=UTF-8")
public class BoardTypesController {
	
	private final BoardTypesService service;
	
	@GetMapping
	public List<BoardTypesDto> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<BoardTypesDto> getById(@PathVariable("id") int id) {
        BoardTypesDto dto = service.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
    public ResponseEntity<Void> create(@RequestBody BoardTypesDto dto) {
        service.insert(dto);
        return ResponseEntity.ok().build();
	}
	
	@PutMapping
    public ResponseEntity<Void> update(@RequestBody BoardTypesDto dto) {
        service.update(dto);
        return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/search")
	public List<BoardTypesDto> search(@RequestBody BoardTypesDto dto) {
		return service.search(dto);
	}
	
}
