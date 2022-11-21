package com.min.study.web.dto;

import com.min.study.domain.music.Music;
import lombok.Getter;

@Getter
public class MusicResponseDto {
    private Long id;
    private String title;
    private String artist;
    private String album;

    public MusicResponseDto(Music entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.artist = entity.getArtist();;
        this.album = entity.getAlbum();
    }
}
