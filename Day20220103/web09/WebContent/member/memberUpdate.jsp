<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<script src="script/member.js"></script>
</head>
<body>
<h2>회원 정보 수정 페이지</h2>
<form action="memberUpdate.do" method="POST" name="frm">
<table>
	<tr>
		<td>이름</td>
		<td>
			<input type="text" name="name" value="${loginUser.name}" readonly>
		</td>
	</tr>
	<tr>
		<td>아이디</td>
		<td>
			<input type="text" name="userid" value="${loginUser.userid}" readonly>
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>
			<input type="password" name="userpwd">
		</td>
	</tr>
	<tr>
		<td>비밀번호 확인</td>
		<td>
			<input type="password" name="pwd_check">
		</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td>
			<input type="text" name="email" value="${loginUser.email}">
		</td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td>
			<input type="text" name="phone" value="${loginUser.phone}">
		</td>
	</tr>
	<tr>
		<td>등급</td>
		<td>
			<c:if test="${loginUser.admin==0}">
				<input type="radio" name="admin" value="0" checked> 일반 회원
				<input type="radio" name="admin" value="1"> 관리자
			</c:if>
			<c:if test="${loginUser.admin==1}">
				<input type="radio" name="admin" value="0"> 일반 회원
				<input type="radio" name="admin" value="1" checked> 관리자
			</c:if>
			
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="정보 수정" onclick="return updateCheck()">
			<input type="reset" value="취소">
		</td>
	</tr>

</table>
</form>
</body>
</html>