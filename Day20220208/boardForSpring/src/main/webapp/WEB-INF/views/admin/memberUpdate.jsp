<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 - 회원 수정</title>
<link rel="stylesheet" href="/resources/style.css">
</head>
<body>
<%@include file="../header.jsp" %>
	<h3>관리자 페이지 - 회원 관리</h3>
	<form action="/admin/memberUpdate/submit" method="POST">
	회원 번호 : <input type="text" value="${memberInfo.memberNum}" name="memberNum" readonly><br>
	회원 아이디 : <input type="text" value="${memberInfo.memberId}" name="memberId"><br>
	회원 이름 : <input type="text" value="${memberInfo.memberName}" name="memberName"><br>
	이메일 : <input type="text" value="${memberInfo.memberEmail}" name="memberEmail"><br>
	전화 번호 : <input type="text" value="${memberInfo.memberPhone}" name="memberPhone"><br>
	<input type="submit" value="수정">
	<input type="button" value="목록보기" onclick="location.href='/admin/memberAdminList'">
	</form>
<%@include file="../footer.jsp" %>
</body>
</html>