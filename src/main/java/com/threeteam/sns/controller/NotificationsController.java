package com.threeteam.sns.controller;

import com.threeteam.sns.service.*;
import com.threeteam.sns.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/notifications")
public class NotificationsController {
	
	@Autowired
	private NotificationsService service  = new NotificationsService();
	
	@GetMapping
	public List<NotificationsDto> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<NotificationsDto[]> getById(@PathVariable String id) {
		NotificationsDto[] dto = service.getById(id);
		if(dto == null) {
			return ResponseEntity.ok(new NotificationsDto[0]);
		}
		return ResponseEntity.ok(dto);
	}
	@PostMapping
    public ResponseEntity<Void> create(@RequestBody NotificationsDto dto) {
        service.insert(dto);
        return ResponseEntity.ok().build();
	}
	
	@PutMapping
    public ResponseEntity<Void> update(@RequestBody NotificationsDto dto) {
        service.update(dto);
        return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("/{id}")String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
	}
	
}
