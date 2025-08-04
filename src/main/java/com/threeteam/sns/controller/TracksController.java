package com.threeteam.sns.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.threeteam.sns.service.TracksService;
import com.threeteam.sns.dto.TracksDto;

@RestController
@RequestMapping("/api/tracks")
public class TracksController {
    @Autowired
    private TracksService service;
    @GetMapping("/search")
    public List<TracksDto> search(@RequestParam String q) {
        return service.searchTracks(q);
    }
}
