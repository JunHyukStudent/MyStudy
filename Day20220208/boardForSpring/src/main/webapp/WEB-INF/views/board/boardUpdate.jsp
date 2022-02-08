<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문 수정</title>
<link rel="stylesheet" href="/resources/style.css">
</head>
<body>
<%@include file="../header.jsp" %>
<h3>QnA 게시판</h3>
<form action="/board/updateSubmit" method="POST">
	<input type="hidden" name="qnaBoardNum" value="${boardInfo.qnaBoardNum}">
	제목 : <input type="text" name="qnaBoardTitle" value="${boardInfo.qnaBoardTitle}"><br><br>
	<textarea rows="10" cols="30" name="qnaBoardContent" >${boardInfo.qnaBoardContent}</textarea><br>
	<input class="btn btn-success" type="submit" value="수정">
	<input class="btn btn-default" type="button" value="목록으로" onclick="location.href='/board/list'">
</form>
<%@include file="../footer.jsp" %>
</body>
</html>