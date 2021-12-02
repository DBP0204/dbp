<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   PostDTO post = (PostDTO)request.getAttribute("post");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
<style>
@font-face {
	font-family: 'Y_Spotlight';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts-20-12@1.0/Y_Spotlight.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

body {
	font-family: 'Y_Spotlight';
}

tr {
	height: 30px;
}

.form-control {
	width: 1000px;
}

#c_summary {
	height: 80px;
}

#c_details {
	height: 300px;
}

.btn {
	padding-top: 30px;
	padding-right: 130px;
	text-align: right;
}

.btnList {
	width: 100px;
	text-align: center;
	border-width: 2px;
	background-color: #ff9593;
	border-style: solid;
	border-radius: 10px;
	height: 40px;
	font-size: 13px;
	font-weight: 300;
	color: white;
	border: 0px;
}
</style>
<script type="module" src="/tag_create.js"></script>
</head>
<body>
	<form name="form">
		<table>
			<tr>
				<td><label for="postTitle" class="col-lg-2 col-form-label">제목</label></td>
				<td><%=post.getPostTitle() %></td>
			</tr>
			<tr>
				<td><label for="c_details" class="col-lg-2 col-form-label">내용</label></td>
				<td><%=post.getPostContent() %></td>
			</tr>
		</table>
	</form>
	<div class="btn">
		<a href="<c:url value='/community/list'/>">
			<button type="button" class="btnList">목록</button>
		</a>
	</div>
</body>
</html>