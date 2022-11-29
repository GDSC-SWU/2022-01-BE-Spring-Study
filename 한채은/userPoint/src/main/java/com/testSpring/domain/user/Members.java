package com.testSpring.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
필드명: 데이터형, null, 추가 사항, 설명

num: long, not null, primary key/auto_increment, 일련번호
id: char(15), not null, , 아이디
pass: char(15), not null, , 비밀번호
name: char(10), not null, , 이름
email: char(80), null, , 이메일 주소
regist_day: char(20), null, , 가입일
point: int, null, , 회원의 포인트
 */
@Getter
@NoArgsConstructor
@Entity
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    @Column(length = 15, nullable = false)
    private String id;

    @Column(length = 15, nullable = false)
    private String pass;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(length = 80)
    private String email;

    @Column(length = 20)
    private String regist_day;

    @Column
    private int point;

    @Builder
    public Members(String id, String pass, String name, String email, String regist_day, int point) {
        this.id = id;
        this.pass = pass;
        this.name = name;
        this.email = email;
        this.regist_day = regist_day;
        this.point = point;
    }
}
