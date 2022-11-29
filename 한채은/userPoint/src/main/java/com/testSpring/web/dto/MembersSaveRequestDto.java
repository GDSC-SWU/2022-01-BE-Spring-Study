package com.testSpring.web.dto;

import com.testSpring.domain.user.Members;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MembersSaveRequestDto {
    private String id;
    private String pass;
    private String name;
    private String email;
    private String regist_day;
    private int point;

    @Builder
    public MembersSaveRequestDto(String id, String pass, String name, String email, String regist_day, int point) {
        this.id = id;
        this.pass = pass;
        this.name = name;
        this.email = email;
        this.regist_day = regist_day;
        this.point = point;
    }

    public Members toEntity(){
        return Members.builder()
                .id(id)
                .pass(pass)
                .name(name)
                .email(email)
                .regist_day(regist_day)
                .point(point)
                .build();
    }
}
