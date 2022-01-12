<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교과목 관리 사이트</title>
</head>
<body>
	<header>
		<h3>교과목 관리 사이트</h3>
	</header>
	<section>
		<c:if test="${flag != null}">
			<h5>총 ${courseCnt}개의 과목이 있습니다.</h5>
		</c:if>
		<form action="CS" method="POST">
			<input type="submit" value="강사보기">
		</form>

		<table border="1">
			<thead>
				<tr>
					<th>과목 코드</th>
					<th>과목 명</th>
					<th>학점</th>
					<th>담당 강사</th>
					<th>요일</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${flag == null}">
					<c:redirect url="CS?command=course_list"/>
				</c:if>
				<c:if test="${flag != null}">
					<c:forEach var="course" items="${courseList}">
						<tr>
							<td><a href="CS?command=course_view&c_id=${course.c_id}">${course.c_id}</a></td>
							<td>${course.c_name}</td>
							<td>${course.credit}</td>
							<td>${course.l_name}</td>
							<td>${course.week}</td>
						</tr>
					</c:forEach>
				</c:if>
				
			</tbody>
		</table>
		<form action="CS" method="POST">
			<input type="hidden" name="command" value="moveCourse_insert">
			<input type="submit" value="교과목 등록">
		</form>
	</section>
	<footer>
		Copyright(c) 2022 박준혁 All right Reserved
	</footer>
</body>
</html>