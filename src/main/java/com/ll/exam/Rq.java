package com.ll.exam;

import com.ll.exam.article.dto.ArticleDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class Rq {
    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public Rq(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        this.req = req;
        this.resp = resp;
    }

    // 파라미터 값을 string으로 반환하는 메서드
    public String getParam(String param, String defaultValue) {
        String value = req.getParameter(param);
        // null이거나 비었으면 디폴트값 반환
        if(value == null || value.trim().length() == 0)
            return defaultValue;
        return value;
    }

    // 파라미터 값을 int로 반환하는 메서드
    public int getIntParam(String param, int defaultValue) {
        String value = req.getParameter(param);
        // null이거나 비었으면 디폴트값 반환
        if(value == null)
            return defaultValue;
        return Integer.parseInt(value);
    }

    // ResponseBody에 body를 담는 메서드
    public void appendBody(String body) throws IOException {
        resp.getWriter().append(body);
    }

    public void setAttr(String name, Object value) {
        // request에 정보 담기
        req.setAttribute(name, value);
    }

    public void view(String path) throws ServletException, IOException {
        // 나머지 작업은 jsp에 토스
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/" + path + ".jsp");
        requestDispatcher.forward(req, resp);
    }

    // request URI 반환(query string 제외한 부분까지)
    public String getPath() {
        return req.getRequestURI();
    }

    // Path Variable을 제외한 URI 반환
    public String getActionPath() {
        // /기준으로 분리해서 3개 값만 이어붙여서 만듦
        String[] bits = req.getRequestURI().split("/");
        return "/%s/%s/%s".formatted(bits[1], bits[2], bits[3]);
    }

    // request method 반환
    public String getMethod() {
        return req.getMethod();
    }
}

