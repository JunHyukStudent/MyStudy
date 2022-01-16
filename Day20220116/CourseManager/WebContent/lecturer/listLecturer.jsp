<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강사 목록</title>
</head>
<body>
	<header>
		<h3>교과목 관리 사이트</h3>
	</header>
	<section>
		<h5>총 ${lecturerCnt}명의 강사가 있습니다.</h5>

		<form action="CS" method="POST">
			<input type="hidden" name="command" value="course_list">
			<input type="submit" value="교과목보기">
		</form>

		<table border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>강사명</th>
					<th>전공</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="lecturer" items="${lecturerList}">
					<tr>
						<td>${lecturer.l_idx}</td>
						<td><a href="LS?command=moveLecturer_update&l_idx=${lecturer.l_idx}">${lecturer.l_name}</a></td>
						<td>${lecturer.l_major}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form action="LS" method="POST">
			<input type="hidden" name="command" value="moveLecturer_insert">
			<input type="submit" value="강사 등록">
		</form>
	</section>
	<footer>
		Copyright(c) 2022 박준혁 All right Reserved
	</footer>
</body>
</html>