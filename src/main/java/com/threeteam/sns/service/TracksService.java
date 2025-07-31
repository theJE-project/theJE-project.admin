package com.threeteam.sns.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import com.threeteam.sns.mapper.TracksMapper;
import com.threeteam.sns.dto.TracksDto;

@Service
@RequiredArgsConstructor
public class TracksService {
    private final TracksMapper mapper;
    public List<TracksDto> searchTracks(String query) {
        return mapper.search(query);
    }
}