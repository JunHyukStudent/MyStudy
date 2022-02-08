<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/style.css">
</head>
<body>
<%@include file="../header.jsp" %>
<h3>로그인</h3>
<form action="loginMember" method="POST">
	아이디 : <input type="text" name="loginId"><br>
	비밀번호 : <input type="password" name="loginPwd"><br>
	<input class="btn btn-success" type="submit" value="로그인">
	<input class="btn btn-default" type="button" value="회원 가입" onclick="location.href='/register/registerForm'">
</form>
<%@include file="../footer.jsp" %>
</body>
</html>