package com.min.study.web;

import com.min.study.service.MusicService;
import com.min.study.web.dto.MusicResponseDto;
import com.min.study.web.dto.MusicSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MusicController {
    private final MusicService musicService;

    @PostMapping("/music/upload") //곡 정보 등록
    public Long save(@RequestBody MusicSaveRequestDto musicSaveRequestDto) {
        return musicService.save(musicSaveRequestDto);
    }

    @GetMapping("/music/list/{id}") //곡 정보 조회
    public MusicResponseDto findById(@PathVariable Long id) {
        return musicService.findById(id);
    }

}
