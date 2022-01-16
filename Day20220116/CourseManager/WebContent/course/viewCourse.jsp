<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교과목 상세보기</title>
</head>
<body>
<h3>교과목 상세보기</h3>

<table border="1">
    <tr>
        <td>교과목 코드</td>
        <td>${courseInfo.c_id}</td>
    </tr>
    <tr>
        <td>과목 명</td>
        <td>${courseInfo.c_name}</td>
    </tr>
    <tr>
        <td>담당 강사</td>
        <td>${courseInfo.c_lecturerKR}</td>
    </tr>
    <tr>
        <td>학점</td>
        <td>${courseInfo.credit}</td>
    </tr>
    <tr>
        <td>요일</td>
        <td>${courseInfo.weekKR}</td>
    </tr>
    <tr>
        <td>시작</td>
        <td>${courseInfo.start_hour}</td>
    </tr>
    <tr>
        <td>종료</td>
        <td>${courseInfo.end_hour}</td>
    </tr>
</table>

<form action="CS" method="POST">
    <input type="hidden" name="command" value="moveCourse_update">
    <input type="hidden" name="c_id" value="${courseInfo.c_id}">
    <input type="submit" value="수정">
</form>
<form action="CS" method="POST">
    <input type="hidden" name="command" value="course_delete">
    <input type="hidden" name="c_id" value="${courseInfo.c_id}">
    <input type="submit" value="삭제">
</form>
<input type="button" value="목록" onclick="location.href='index.jsp'">
</body>
</html>