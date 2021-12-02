<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성 폼</title>
<script>
	function registerPost() {
		if (form.postTitle.value == "") {
			alert("제목을 입력하십시오.");
			form.userId.focus();
			return false;
		} 
		if (form.postContent.value == "") {
			alert("내용을 입력하십시오.");
			form.password.focus();
			return false;
		}		
		form.submit();
	}
</script>
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

.btnOpen {
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
	<form name="form" method="POST"
		action="<c:url value='/community/register'/>">
		<table>
			<tr>
				<td><label for="postTitle" class="col-lg-2 col-form-label">제목</label></td>
				<td><input type="text" name="postTitle" class="form-control"
					placeholder="제목"></td>
			</tr>
			<tr>
				<td><label for="c_details" class="col-lg-2 col-form-label">내용</label></td>
				<td><textarea type="text" name="postContent" class="form-control" style="height:300px;"
					placeholder="내용을 입력하세요."></textarea></td>
			</tr>
		</table>
	</form>
	<div class="btn">
		<button type="button" class="btnOpen" onClick="registerPost()">등록</button>
	</div>
</body>
</html>