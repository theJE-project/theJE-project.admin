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
@RequestMapping(value = "/api/notifications", produces = "application/json; charset=UTF-8")
public class NotificationsController {
	
	private final NotificationsService service;
	
	@GetMapping
	public List<NotificationsDto> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<NotificationsDto> getById(@PathVariable("id") int id) {
        NotificationsDto dto = service.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
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
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/search")
	public List<NotificationsDto> search(@RequestBody NotificationsDto dto) {
		return service.getListByUsers(dto);
	}
	
	@PutMapping("/allRead")
	public ResponseEntity<Void> markAllAsRead(@RequestBody NotificationsDto dto) {
		service.updateAllRead(dto);
		return ResponseEntity.ok().build();
	}
	
}
