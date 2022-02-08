<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문 작성</title>
<link rel="stylesheet" href="/resources/style.css">
</head>
<body>
<%@include file="../header.jsp" %>
<h3>QnA 게시판</h3>
<form action="/board/insertSubmit" method="POST">
	제목 : <input type="text" name="qnaBoardTitle"><br><br>
	<textarea rows="10" cols="30" name="qnaBoardContent"></textarea><br>
	<input class="btn btn-success" type="submit" value="등록">
	<input class="btn btn-default" type="button" value="목록으로" onclick="location.href='/board/list'">
</form>
<%@include file="../footer.jsp" %>
</body>
</html>