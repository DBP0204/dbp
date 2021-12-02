<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List, model.ClassParticipateDTO, model.service.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		border-style: solid;
		border-collapse: collapse;
	}
	td {
		border-style: solid;
	}
</style>
</head>
<body>
<%
	ClassParticipateManager classMan = new ClassParticipateManager();
	List<ClassParticipateDTO> classList = classMan.getClassParticipateList();
	request.setAttribute("classList", classList);
%>
	<div class="container">
		<br>
		<h4>클래스 참여 내역 조회</h4>
		<br>
		<table>
			<tr>
				<td>이름</td>
				<td>날짜</td>
				<td>지역</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
			<c:forEach var="Class" items="${classList}">
				<tr class="table">
					<td>${Class.c_name}</td>
					<td>${Class.c_date}</td>
					<td>${Class.c_local}</td>
					<td><a href="">수정</a><br> <a href="">삭제</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>