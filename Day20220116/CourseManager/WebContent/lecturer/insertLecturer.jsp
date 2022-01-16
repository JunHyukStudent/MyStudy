<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강사 등록</title>
</head>
<body>
	<h3>강사 등록</h3>
	<form action="">
        <table border="1">
            <tr>
                <td>강사 번호</td>
                <td><input type="number" name="l_idx" value="${l_idx}" readonly></td>
            </tr>
            <tr>
                <td>강사 명</td>
                <td><input type="text" name="l_name"></td>
            </tr>
            <tr>
                <td>전공</td>
                <td><input type="text" name="l_major"></td>
            </tr>
            <tr>
                <td>세부 전공</td>
                <td><input type="text" name="field"></td>
            </tr>
        </table>
        <input type="button" value="목록" onclick="location.href='LS?command=moveLecturer_list'">
        <input type="hidden" name="command" value="lecturer_insert">
        <input type="submit" value="완료">
	</form>
</body>
</html>