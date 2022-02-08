<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 - 질문 상세보기</title>
<link rel="stylesheet" href="/resources/style.css">
</head>
<body>
<%@include file="../header.jsp" %>
<h3>QnA 게시판</h3>
<div id="wrap">
	<p>제목 ${boardInfo.qnaBoardTitle}</p>
	<p>작성일 : ${boardInfo.qnaBoardRegdate} </p>
	<p>작성자 : ${boardInfo.memberName} </p>
	<p>조회수 : ${boardInfo.qnaBoardCount} </p>
	<p>${boardInfo.qnaBoardContent} </p>
	
	<hr>
	<c:if test="${!empty comment}">
		답변 : ${comment.commentContent}<br>
		작성일 ${comment.commentRegdate}<br>
		<button class="btn btn-danger" onclick="location.href='/admin/boardDelete/${boardInfo.qnaBoardNum}'">삭제</button>
	</c:if>
	<c:if test="${empty comment}">
		<form action="/admin/commentWrite" method="POST">
			<input type="hidden" value="${boardInfo.qnaBoardNum}" name="qnaBoardNum">
			답변 : <textarea cols="20" rows="10" name="commentContent"></textarea><br>
			<input class="btn btn-success" type="submit" value="답글 작성">
			<button class="btn btn-danger" onclick="location.href='/admin/boardDelete/${boardInfo.qnaBoardNum}'">삭제</button>
		</form>
	</c:if>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>