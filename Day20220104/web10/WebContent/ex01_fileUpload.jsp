<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>파일 업로드</h2>
<form action="upLoad" method="POST" enctype="multipart/form-data">
	글쓴이 : <input type="text" name="name"><br>
	제   목 : <input type="text" name="title"><br>
	파일지정 : <input type="file" name="fileUpload"><br>
	<input type="submit" value="전송">
</form>
</body>
</html>