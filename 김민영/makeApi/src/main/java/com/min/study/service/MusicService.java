package com.min.study.service;

import com.min.study.domain.music.Music;
import com.min.study.domain.music.MusicRepository;
import com.min.study.web.dto.MusicResponseDto;
import com.min.study.web.dto.MusicSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MusicService {
    private final MusicRepository musicRepository;

    @Transactional
    public Long save(MusicSaveRequestDto musicSaveRequestDto) {
        return musicRepository.save(musicSaveRequestDto.toEntity()).getId();
    }

    public MusicResponseDto findById (Long id) {
        Music entity = musicRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 곡이 존재하지 않습니다. id = " + id));

        return new MusicResponseDto(entity);
    }
}
