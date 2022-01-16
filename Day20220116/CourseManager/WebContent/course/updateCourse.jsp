<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교과목 수정</title>
</head>
<body>
	<h3>교과목 수정</h3>
	<form action="CS" method="POST">
		<table border="1">
			<tr>
				<td>교과목 코드</td>
				<td><input type="text" name="c_id" value="${courseInfo.c_id}" readonly></td>
			</tr>
			<tr>
				<td>과목 명</td>
				<td><input type="text" name="c_name" value="${courseInfo.c_name}"></td>
			</tr>
			<tr>
				<td>담당 강사</td>
				<td>
					<select name="c_lecturer">
						<c:forEach var="lec" items="${lecList}">
							<c:choose>
								<c:when test="${lec.l_idx == courseInfo.c_lecturer}">
									<option value="${lec.l_idx}" selected>${lec.l_name}</option>
								</c:when>
								<c:otherwise>
									<option value="${lec.l_idx}">${lec.l_name}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>학점</td>
				<td><input type="text" name="credit" value="${courseInfo.credit}"></td>
			</tr>
			<tr>
				<td>요일</td>
				<td>
					<c:choose>
						<c:when test="${courseInfo.week == 1}">
							<input type="radio" name="week" value="1" checked>월 
						</c:when>
						<c:otherwise>
							<input type="radio" name="week" value="1">월 
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${courseInfo.week == 2}">
							<input type="radio" name="week" value="2" checked>화 
						</c:when>
						<c:otherwise>
							<input type="radio" name="week" value="2">화 
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${courseInfo.week == 3}">
							<input type="radio" name="week" value="3" checked>수 
						</c:when>
						<c:otherwise>
							<input type="radio" name="week" value="3">수 
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${courseInfo.week == 4}">
							<input type="radio" name="week" value="4" checked>목
						</c:when>
						<c:otherwise>
							<input type="radio" name="week" value="4">목
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${courseInfo.week == 5}">
							<input type="radio" name="week" value="5" checked>금
						</c:when>
						<c:otherwise>
							<input type="radio" name="week" value="5">금
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${courseInfo.week == 6}">
							<input type="radio" name="week" value="6" checked>토
						</c:when>
						<c:otherwise>
							<input type="radio" name="week" value="6">토
						</c:otherwise>
					</c:choose> 
				</td>
			</tr>
			<tr>
				<td>시작</td>
				<td><input type="text" name="start_hour" value="${courseInfo.start_hour}"></td>
			</tr>
			<tr>
				<td>종료</td>
				<td><input type="text" name="end_hour" value="${courseInfo.end_hour}"></td>
			</tr>
		</table>
		<input type="hidden" name="command" value="course_update">
		<input type="button" value="목록" onclick="location.href='index.jsp'">
		<input type="submit" value="완료">
	</form>
</body>
</html>