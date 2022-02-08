<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 게시판</title>
<link rel="stylesheet" href="/resources/style.css">
</head>
<body>
<%@include file="../header.jsp" %>
<h3>QnA 게시판</h3>
	<div id="wrap">
		<c:if test="${!empty boardList}">
			<table border=1>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
				<c:forEach var="board" items="${boardList}">
					<tr>
						<td>${board.qnaBoardNum}</td>
						<td><a href="<c:url value='/board/info/${board.qnaBoardNum}' />">${board.qnaBoardTitle}</a></td>
						<td>${board.memberName}</td>
						<td>${board.qnaBoardRegdate}</td>
						<td>${board.qnaBoardCount}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<div class="alignRight">
			<c:if test="${!empty authInfo}">
				<input class="btn btn-default" type="button" value="글작성" onclick="location.href='insert'">
			</c:if>
		</div>
	</div>
<%@include file="../footer.jsp" %>
</body>
</html>