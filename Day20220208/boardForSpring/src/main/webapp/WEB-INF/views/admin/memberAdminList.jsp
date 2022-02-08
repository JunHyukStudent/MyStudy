<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>
<link rel="stylesheet" href="/resources/style.css">
</head>
<body>
<%@include file="../header.jsp" %>
<h3>관리자 페이지 - 회원 관리</h3>
<div id="wrap">
	<table border=1>
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>이름</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	
	<c:forEach var="member" items="${memberAdminList}">
		<tr>
			<td>${member.memberNum}</td>
			<td>${member.memberId}</td>
			<td>${member.memberName}</td>
			<td><button class="btn btn-warning" onclick="location.href='/admin/memberUpdate/${member.memberNum}'">수정</button></td>
			<td>
				<c:if test="${member.memberName != '관리자'}">
					<button class="btn btn-danger" onclick="location.href='/admin/memberDelete/${member.memberNum}'">삭제</button>
				</c:if>
			</td>
		</tr>
	</c:forEach>
	
	</table>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>