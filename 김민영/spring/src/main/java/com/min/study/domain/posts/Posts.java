package com.min.study.domain.posts;

import com.min.study.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter //Getter 메소드 자동생성
@NoArgsConstructor //기본 생성자 자동 추가
@Entity //테이블과 링크될 클래스 명시
public class Posts extends BaseTimeEntity {
    @Id //해당 테이블의 PK필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성규칙
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //빌더 패턴 클래스 생성
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

