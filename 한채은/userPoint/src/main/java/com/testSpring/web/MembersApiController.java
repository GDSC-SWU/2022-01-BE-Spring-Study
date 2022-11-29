package com.testSpring.web;

import com.testSpring.service.user.MembersService;
import com.testSpring.web.dto.MembersResponseDto;
import com.testSpring.web.dto.MembersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MembersApiController {

    private final MembersService membersService;

    @PostMapping("/members")
    public Long save(@RequestBody MembersSaveRequestDto requestDto) {
        return membersService.save(requestDto);
    }

    // num으로 회원정보 불러오기
    @GetMapping("/members/{num}")
    public MembersResponseDto findById(@PathVariable Long num)
    {
        return membersService.findById(num);
    }
}
