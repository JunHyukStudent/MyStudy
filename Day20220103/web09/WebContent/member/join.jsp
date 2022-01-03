<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 페이지</title>
<script src="script/member.js"></script>
</head>
<body>
<h2>회원 가입 페이지</h2>
'*'표시 항목은 필수 입력항목입니다.
<form action="join.do" method="POST" name="frm">
<table>
	<tr>
		<td>이름</td>
		<td> <input type="text" name="name" required>* </td>
	</tr>
	<tr>
		<td>아이디</td>
		<td> 
			<input type="text" name="userid" required>* 
			<input type="hidden" name="reid" ><!-- 중복확인했는지 여부 -->
			<input type="button" value="중복체크" onclick="idCheck()">
		
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td> <input type="password" name="userpwd" required>* </td>
	</tr>
	<tr>
		<td>비밀번호 확인</td>
		<td> <input type="password" name="pwd_check" required> *</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td> <input type="email" name="email" > </td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td> <input type="tel" name="phone" > </td>
	</tr>
	<tr>
		<td>등급</td>
		<td>
			<input type="radio" name="admin" value="0" checked> 일반 회원
			<input type="radio" name="admin" value="1" > 관리자
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="회원 가입" onclick="return joinCheck()">
			<input type="reset" value="취소">
		</td>
	</tr>
	<tr>
		<td colspan="2">${message}</td>
	</tr>
	
</table>
</form>
</body>
</html>