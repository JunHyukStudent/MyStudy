<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
<fieldset>
	<form:form action="registMember" commandName="formData">
		아이디 : <form:input path="memberId"/><br>
		비밀번호 : <form:password path="memberPassword"/><br>
		비밀번호 확인 : <form:password path="confirmPassword"/><br>
		이름 : <form:input path="memberName"/><br>
		이메일 : <form:input path="memberEmail"/><br>
		전화번호 : <form:input path="memberPhone"/><br>
		<input type="submit" value="회원 가입">
		<input type="button" value="돌아가기" onclick="location.href='/'">
	</form:form>
</fieldset>
</body>
</html>