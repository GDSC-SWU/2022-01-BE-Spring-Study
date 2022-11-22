package com.HJHJ.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 300, nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column
    private int price;

    @Builder
    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
}

