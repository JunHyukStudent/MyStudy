<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강사 수정</title>
</head>
<body>
	<h3>강사 등록</h3>
	<form action="">
        <table border="1">
            <tr>
                <td>강사 번호</td>
                <td><input type="number" name="l_idx" value="${lecturer.l_idx}" readonly></td>
            </tr>
            <tr>
                <td>강사 명</td>
                <td><input type="text" name="l_name" value="${lecturer.l_name}"></td>
            </tr>
            <tr>
                <td>전공</td>
                <td><input type="text" name="l_major" value="${lecturer.l_major}"></td>
            </tr>
            <tr>
                <td>세부 전공</td>
                <td><input type="text" name="field" value="${lecturer.field}"></td>
            </tr>
            <tr>
                <td>담당 과목</td>
                <td>
                    <c:choose>
                        <c:when test="${empty lecturerCourseList}">
                            담당 과목이 없습니다.
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="course" items="${lecturerCourseList}" varStatus="s">
                                <c:choose>
                                    <c:when test="${s.last}">
                                        ${course}
                                    </c:when>
                                    <c:otherwise>
                                        ${course}, 
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                   
                </td>
            </tr>
        </table>
        <input type="button" value="목록" onclick="location.href='LS?command=moveLecturer_list'">
        <input type="hidden" name="command" value="lecturer_update">
        <input type="submit" value="완료">
	</form>
</body>
</html>