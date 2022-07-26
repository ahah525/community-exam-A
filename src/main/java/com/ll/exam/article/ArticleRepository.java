package com.ll.exam.article;

import com.ll.exam.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    private static List<ArticleDto> articles;
    private static long lastId;

    // static 생성자로 초기화해야 함
    static {
        articles = new ArrayList<>();
        lastId = 0;
    }

    // 등록된 게시물의 id 반환
    public long write(String title, String body) {
        // 리스트에 등록
        ArticleDto articleDto = new ArticleDto(++lastId, title, body);
        articles.add(articleDto);

        return lastId;
    }
}
