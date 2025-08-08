package com.threeteam.sns.dto;

import lombok.Data;

@Data
public class TracksDto {
	private Integer id;
    private String preview;      // 미리듣기 URL
    private String titleShort;   // title_short
    private String albumCover;   // album.cover_medium
    private String albumTitle;   // album.title
    private String artistName;   // artist.name
    private int duration;        // 음악 길이 (초)
}
