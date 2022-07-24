package com.ll.exam.article;

import com.ll.exam.Rq;

import java.io.IOException;

public class ArticleController {
    public void showList(Rq rq) throws IOException {
        rq.appendBody("게시물 리스트");
    }
}
