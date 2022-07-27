<%@ page import="com.ll.exam.article.dto.ArticleDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    ArticleDto article = (ArticleDto) request.getAttribute("article");
%>

<h1>게시물 수정폼</h1>

<script>
    function ArticleSave__submitForm(form) {
        // 제목 입력 확인
        form.title.value = form.title.value.trim();
        if (form.title.value.length == 0) {
            alert("제목을 입력해주세요");
            form.title.focus();
            return;
        }
        // 내용 입력 확인
        form.body.value = form.body.value.trim();
        if (form.body.value.length == 0) {
            alert("내용을 입력해주세요.");
            form.body.focus();
            return;
        }
        // 폼 제출
        form.submit();
    }
</script>
<form method="POST" onsubmit="ArticleSave__submitForm(this); return false;">
    <div>
        <div>
            <span>id: <%=article.getId()%></span>
        </div>
        <span>제목</span>
        <div>
            <input name="title" type="text" maxlength="50" placeholder="제목을 입력해주세요." value="<%=article.getTitle()%>"/>
        </div>
    </div>
    <div>
        <span>내용</span>
        <div>
            <input name="body" type="text" maxlength="300" placeholder="내용을 입력해주세요." value="<%=article.getBody()%>"/>
        </div>
    </div>
    <div>
        <div>
            <input type="submit" value="수정" />
        </div>
    </div>
</form>