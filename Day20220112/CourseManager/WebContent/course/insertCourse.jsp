<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교과목 등록</title>
</head>
<body>
	<h3>교과목 등록</h3>
	<form action="CS" method="POST">
		<table border="1">
			<tr>
				<td>교과목 코드</td>
				<td><input type="text" name="c_id"></td>
			</tr>
			<tr>
				<td>과목 명</td>
				<td><input type="text" name="c_name"></td>
			</tr>
			<tr>
				<td>담당 강사</td>
				<td>
					<select name="c_lecturer">
						<c:forEach var="lec" items="${lecList}">
							<option value="${lec.l_idx}">${lec.l_name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>학점</td>
				<td><input type="text" name="credit"></td>
			</tr>
			<tr>
				<td>요일</td>
				<td>
					<input type="radio" name="week" value="1">월 
					<input type="radio" name="week" value="2">화 
					<input type="radio" name="week" value="3">수 
					<input type="radio" name="week" value="4">목 
					<input type="radio" name="week" value="5">금 
					<input type="radio" name="week" value="6">토 
				</td>
			</tr>
			<tr>
				<td>시작</td>
				<td><input type="text" name="start_hour"></td>
			</tr>
			<tr>
				<td>종료</td>
				<td><input type="text" name="end_hour"></td>
			</tr>
		</table>
		<input type="hidden" name="command" value="course_insert">
		<input type="button" value="목록" onclick="location.href='index.jsp'">
		<input type="submit" value="완료">
	</form>
</body>
</html>