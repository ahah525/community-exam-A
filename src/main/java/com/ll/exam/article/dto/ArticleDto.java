package com.ll.exam.article.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ArticleDto {
    private long id;
    private String title;   // 제목
    private String body;    // 내용
}
