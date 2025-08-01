package com.threeteam.sns.controller;

import com.threeteam.sns.service.*;
import com.threeteam.sns.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/communities")
public class CommunitiesController {
	
	@Autowired
	private CommunitiesService service  = new CommunitiesService();
	@Autowired
	private ImagesService images = new ImagesService();
	
	@GetMapping
	public List<CommunitiesDto> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<CommunitiesDto> getById(@PathVariable("/{id}") Long id) {
        CommunitiesDto dto = service.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
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
        return ResponseEntity.ok().build();
	}

	@PutMapping
    public ResponseEntity<Void> update(@RequestBody CommunitiesDto dto) {
        service.update(dto);
        return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("/{id}") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
	}
	
}
