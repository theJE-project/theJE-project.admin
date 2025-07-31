package com.threeteam.sns.mapper;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.threeteam.sns.dto.TracksDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class TracksMapper {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String SEARCH_API_URL = "https://api.deezer.com/search?q={query}";

    @SuppressWarnings("unchecked")
    public List<TracksDto> search(String query) {
        Map<String, Object> response = restTemplate.getForObject(SEARCH_API_URL, Map.class, query);
        List<Map<String, Object>> data = (List<Map<String, Object>>) response.get("data");
        List<TracksDto> tracks = new ArrayList<>();

        if (data != null) {
            for (Map<String, Object> item : data) {
                TracksDto track = new TracksDto();

                track.setPreview((String) item.get("preview"));
                track.setTitleShort((String) item.get("title_short"));
                track.setDuration((Integer) item.get("duration"));

                Map<String, Object> album = (Map<String, Object>) item.get("album");
                if (album != null) {
                    track.setAlbumCover((String) album.get("cover_medium"));
                    track.setAlbumTitle((String) album.get("title"));
                }

                Map<String, Object> artist = (Map<String, Object>) item.get("artist");
                if (artist != null) {
                    track.setArtistName((String) artist.get("name"));
                }

                tracks.add(track);
            }
        }
        return tracks;
    }
}