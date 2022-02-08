<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<link rel="stylesheet" href="/resources/style.css">
</head>
<body>
<%@include file="../header.jsp" %>
<fieldset id="wrap">
	<form:form action="registMember" commandName="formData">
		아이디 : <form:input path="memberId"/><br>
		비밀번호 : <form:password path="memberPassword"/><br>
		비밀번호 확인 : <form:password path="confirmPassword"/><br>
		이름 : <form:input path="memberName"/><br>
		이메일 : <form:input path="memberEmail"/><br>
		전화번호 : <form:input path="memberPhone"/><br><br>
		<input class="btn btn-success" type="submit" value="회원 가입">
		<input class="btn btn-default" type="button" value="돌아가기" onclick="location.href='/'">
	</form:form>
</fieldset>
<%@include file="../footer.jsp" %>
</body>
</html>