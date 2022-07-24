package com.ll.exam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

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

    // 파라미터 값을 반환하는 메서드
    public int getIntParam(String param, int defaultValue) {
        String value = req.getParameter(param);
        if(value == null)
            return defaultValue;
        return Integer.parseInt(value);
    }

    // ResponseBody에 body를 담는 메서드
    public void appendBody(String body) throws IOException {
        resp.getWriter().append(body);
    }
}

