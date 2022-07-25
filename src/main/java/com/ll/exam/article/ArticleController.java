package com.ll.exam.article;

import com.ll.exam.Rq;
import com.ll.exam.article.dto.ArticleDto;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArticleController {
    public void showList(Rq rq) throws IOException, ServletException {
        List<ArticleDto> articleDtos = new ArrayList<>();

        articleDtos.add(new ArticleDto(5, "제목 5", "내용 5"));
        articleDtos.add(new ArticleDto(4, "제목 4", "내용 4"));
        articleDtos.add(new ArticleDto(3, "제목 3", "내용 3"));
        articleDtos.add(new ArticleDto(2, "제목 2", "내용 2"));
        articleDtos.add(new ArticleDto(1, "제목 1", "내용 1"));

        // jsp에서 사용할 수 있도록 request에 게시물 리스트 담기
        rq.setAttr("articles", articleDtos);

        rq.view("usr/article/list");
    }

    public void showWrite(Rq rq) throws IOException, ServletException {
        rq.view("usr/article/write");
    }
}