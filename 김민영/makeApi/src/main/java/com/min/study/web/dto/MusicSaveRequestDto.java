package com.min.study.web.dto;

import com.min.study.domain.music.Music;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MusicSaveRequestDto {
    private String title;
    private String artist;
    private String album;

    @Builder
    public MusicSaveRequestDto(String title, String artist, String album) {
        this.title = title;
        this.artist = artist;
        this.album = album;
    }

    public Music toEntity() {
        return Music.builder().title(title).artist(artist).album(album).build();
    }
}
