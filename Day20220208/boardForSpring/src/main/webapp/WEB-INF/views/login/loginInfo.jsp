<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
<link rel="stylesheet" href="/resources/style.css">
</head>
<body>
<%@include file="../header.jsp" %>
번호 : ${memberInfo.memberNum}<br>
아이디 : ${memberInfo.memberId}<br>
이름 : ${memberInfo.memberName}<br>
이메일 : ${memberInfo.memberEmail}<br>
전화 번호 : ${memberInfo.memberPhone}<br>
<%@include file="../footer.jsp" %>
</body>
</html>