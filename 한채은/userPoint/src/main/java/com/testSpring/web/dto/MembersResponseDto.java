package com.testSpring.web.dto;

import com.testSpring.domain.user.Members;
import lombok.Getter;

@Getter
public class MembersResponseDto {
    private Long num;
    private String id;
    private String pass;
    private String name;
    private String email;
    private String regist_day;
    private int point;

    public MembersResponseDto(Members entity) {
        this.num = entity.getNum();
        this.id = entity.getId();
        this.pass = entity.getPass();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.regist_day = entity.getRegist_day();
        this.point = entity.getPoint();
    }
}
