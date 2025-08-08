package com.threeteam.sns.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threeteam.sns.service.SearchService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/search", produces = "application/json; charset=UTF-8")
public class SearchController {
	
	private final SearchService service;
	
	@PostMapping
	public ResponseEntity<Map<String, List<Map<String, Object>>>> search(@RequestBody HashMap<String, Object> paramsMap) {
		Map<String, List<Map<String, Object>>> result = service.search(paramsMap);
		
		//return list.size() > 0 ? ResponseEntity.ok(list) : ResponseEntity.notFound().build();
		return result.values().stream().anyMatch(list -> !list.isEmpty())
		        ? ResponseEntity.ok(result)
		        : ResponseEntity.notFound().build();
	}
	
}
