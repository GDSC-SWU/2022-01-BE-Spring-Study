package com.testSpring.service.user;

import com.testSpring.domain.user.Members;
import com.testSpring.domain.user.MembersRepository;
import com.testSpring.web.dto.MembersResponseDto;
import com.testSpring.web.dto.MembersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MembersService {
    private final MembersRepository membersRepository;

    // 가입 정보를 DB에 저장
    @Transactional
    public Long save(MembersSaveRequestDto requestDto) {
        return membersRepository.save(requestDto.toEntity()).getNum();
    }

    // 회원 정보 불러오기
    public MembersResponseDto findById (Long num) {
        Members entity = membersRepository.findById(num).orElseThrow(() -> new IllegalArgumentException("해당 회원정보가 없습니다."));

        return new MembersResponseDto(entity);
    }

}
