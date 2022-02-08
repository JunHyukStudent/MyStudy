<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문 상세보기</title>
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
	
	<c:if test="${boardInfo.memberNum == authInfo.memberNum}">
		<button class="btn btn-warning" onclick="location.href='/board/update/${boardInfo.qnaBoardNum}'">수정하기</button>
		<button class="btn btn-danger" onclick="location.href='/board/delete/${boardInfo.qnaBoardNum}'">삭제하기</button>
	</c:if>
	<hr>
	<c:if test="${!empty comment}">
		답변 : ${comment.commentContent}<br>
		작성일 ${comment.commentRegdate}
	</c:if>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>