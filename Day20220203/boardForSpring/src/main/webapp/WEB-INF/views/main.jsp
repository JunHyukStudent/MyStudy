<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
<p><a href="<c:url value='/register/registerForm'/>">[회원가입]</a></p>
<p><a href="<c:url value='/login/loginForm'/>">[로그인]</a></p>
<p><a href="<c:url value='/board/list'/>">[QnA게시판 보기]</a></p>
</body>
</html>