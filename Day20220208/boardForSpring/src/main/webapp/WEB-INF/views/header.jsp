<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<div id="wrap">
<h1>그린 아카데미</h1>

<table>
	<tr>
		<td align="right">
		<c:choose>
			<c:when test="${empty authInfo}">
			<a href="<c:url value='/login/loginForm' />">로그인</a>
			<a href="<c:url value='/register/registerForm' />">회원 가입</a>
			</c:when>
			<c:when test="${authInfo eq 'admin'}">
			<a href="<c:url value='/logout' />">로그 아웃</a>
			</c:when>
			<c:otherwise>
			${authInfo.memberName}님 반갑습니다.
			|
			<a href="<c:url value='/logout' />">로그아웃</a>
			/
			<a href="<c:url value='/login/loginInfo' />">정보 보기</a>
			</c:otherwise>
			
		
		</c:choose>
		</td>
	</tr>
</table>
		
		    <a href="<c:url value='/' />">메인으로</a>
       	


</div>
		  
<br>
</body>
</html>