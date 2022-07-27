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

    public List<ArticleDto> findAll() {
        return articles;
    }

    public ArticleDto findById(long id) {
        for (ArticleDto articleDto : articles) {
            if(articleDto.getId() == id)
                return articleDto;
        }
        return null;
    }

    public void delete(long id) {
        ArticleDto articleDto = findById(id);
        articles.remove(articleDto);
    }

    public void modify(long id, String title, String body) {
        ArticleDto articleDto = findById(id);
        articleDto.setTitle(title);
        articleDto.setBody(body);
    }
}
