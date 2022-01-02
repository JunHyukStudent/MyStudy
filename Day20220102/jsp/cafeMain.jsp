<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="web08.CafeMenu" %>
<%@ page import="web08.CafeOrder" %>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>카페 주문 프로그램</title>
<style>
	*{
		margin: 0 auto;
		align-content: center;
	}
	th{
		padding: 20px;
	}
</style>
</head>
<body>

	<c:choose>
 		<c:when test="${menu==null}">
 			<script>
 				location.href="errorPage.html";
 			</script>
 		</c:when>
 	</c:choose>

<fieldset> 	
	<legend><h3> Cafe Order </h3></legend>
	<table>
		<tr>
			<td colspan="5">
				<form action="" method="POST">
					<select name="cname">
						<c:forEach items="${menu}" var="menu" varStatus="s">
							<option value="${s.index}">${menu.cname}</option>
						</c:forEach>	
					</select>
					<select name="ctype">
						<option value="tall">톨</option>
						<option value="grande">그란데</option>
						<option value="venti">벤티</option>
					</select>
					<input type="number" name="cnum">
					<input type="submit" value="주문">
				</form>
			</td>
		</tr>
		<tr>
			<th>커피</th>
			<th>타입</th>
			<th>가격</th>
			<th>개수</th>
			<th>합계</th>
		</tr>
		<c:forEach items="${order}" var="order">
			<tr>
				<td>${order.cname}</td>
				<td>${order.ctype}</td>
				<td>${order.cprice}</td>
				<td>${order.cnum}</td>
				<td>${order.cpriceSum}</td>
			</tr>	
		</c:forEach>
		
	</table>
</fieldset>
</body>
</html>