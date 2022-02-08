<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 관리</title>
<link rel="stylesheet" href="/resources/style.css">
</head>
<body>
<%@include file="../header.jsp" %>
<h3>관리자 페이지 - 게시물 관리</h3>
<div id="wrap">
	<table border=1>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="board" items="${boardAdminList}">
			<tr>
				<td>${board.qnaBoardNum}</td>
				<td><a href="<c:url value='/admin/boardInfo/${board.qnaBoardNum}'/>">${board.qnaBoardTitle}</a>
					<c:if test="${!board.commentYN}">
						<a class="answerWait">[답변 대기중]</a>
					</c:if>
				</td>
				<td>${board.memberName}</td>
				<td>${board.qnaBoardRegdate}</td>
				<td>${board.qnaBoardCount}</td>
			</tr>
		</c:forEach>
	</table>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>