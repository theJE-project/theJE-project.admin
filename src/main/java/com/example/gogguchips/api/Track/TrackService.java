package com.example.gogguchips.api.Track;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrackService {

    private final TrackMapper mapper;

    public List<TrackData> searchTracks(String query) {
        return mapper.search(query);
    }
}