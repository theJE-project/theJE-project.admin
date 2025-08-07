package com.threeteam.sns.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.threeteam.sns.dto.TracksDto;
import com.threeteam.sns.service.BoardTypesService;
import com.threeteam.sns.service.TracksService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/tracks", produces = "application/json; charset=UTF-8")
public class TracksController {
    
	private final TracksService service;
    
    @GetMapping("/search")
    public List<TracksDto> search(@RequestParam("q") String q) {
    	System.out.println("TracksController search : " + q);
        return service.searchTracks(q);
    }
}