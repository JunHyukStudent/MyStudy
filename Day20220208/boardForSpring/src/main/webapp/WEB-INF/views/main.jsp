<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<link rel="stylesheet" href="/resources/style.css">
</head>
<body>
<%@include file="./header.jsp" %>

	<c:if test="${authInfo.memberName != '관리자'}">
		<p><a href="<c:url value='/board/list'/>">[QnA게시판 보기]</a></p>
	</c:if>
	<c:if test="${authInfo.memberName == '관리자'}">
		<button class="btn btn-info" onclick="location.href='/admin/memberAdminList'">회원 관리</button>
		<button class="btn btn-info" onclick="location.href='/admin/boardAdminList'">게시물 관리</button>
	</c:if>
	
<%@include file="./footer.jsp" %>
</body>
</html>