<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ll.exam.article.dto.ArticleDto" %>

<%
    // request에서 게시물 리스트 가져오기
    List<ArticleDto> articles = (List<ArticleDto>) request.getAttribute("articles");
%>
<%@ include file="../common/header.jspf"%>

<!-- 보통 섹션으로 구분함 -->
<section>
    <!-- container: 반응형, 최대너비가 지정되어있어 무한정 커지는 걸 막아줌 -->
    <div class="container px-3 mx-auto">
        <!-- text-lg: font-size, line-height 설정 -->
        <h1 class="font-bold text-lg">게시물 리스트</h1>
        <!-- mt: margin-top -->
        <ul class="mt-5">
            <% for(ArticleDto article : articles) { %>
            <li class="flex">
                <a class="w-[40px] hover:underline hover:text-[red]" href="/usr/article/detail/free/<%=article.getId()%>">
                    <%=article.getId()%>
                </a>
                <!-- flex-grow:  -->
                <a class="flex-grow hover:underline hover:text-[red]" href="/usr/article/detail/free/<%=article.getId()%>">
                    <%=article.getTitle()%>
                </a>
                <a class="w-[100px] hover:underline hover:text-[red]" href="/usr/article/modify/free/<%=article.getId()%>">수정</a>
                <!-- 사용자가 취소 click -> return false -> href 이동X -->
                <a onclick="if(!confirm('해당 게시글을 삭제하시겠습니까?')) return false;" class="w-[100px] hover:underline hover:text-[red]" href="/usr/article/delete/free/<%=article.getId()%>">삭제</a>
            </li>
            <% } %>
        </ul>
    </div>
</section>

<%@ include file="../common/footer.jspf"%>