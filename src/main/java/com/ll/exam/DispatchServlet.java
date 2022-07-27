package com.ll.exam;

import com.ll.exam.article.ArticleController;
import com.ll.exam.member.MemberController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/usr/*")
public class DispatchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Rq rq = new Rq(req, resp);

        MemberController memberController = new MemberController();
        ArticleController articleController = new ArticleController();

        // 요청 메서드(get, post)에 따라 구분
        switch (rq.getMethod()) {
            case "GET":
                switch (rq.getActionPath()) {
                    case "/usr/article/list":
                        articleController.showList(rq);
                        break;
                    case "/usr/article/detail":
                        articleController.showDetail(rq);
                        break;
                    case "/usr/article/write":
                        articleController.showWrite(rq);
                        break;
                    case "/usr/article/modify":
                        articleController.showModifyForm(rq);
                        break;
                    case "/usr/member/login":
                        memberController.showLogin(rq);
                        break;
                    case "/usr/article/delete":
                        articleController.doDelete(rq);
                        break;
                }
                break;
            case "POST":
                switch (rq.getActionPath()) {
                    case "/usr/article/write":
                        articleController.doWrite(rq);
                }
                break;
        }
    }
}
