<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<style type="text/css">
.add_button{
	float: right;
	width: 60px;
    text-align: center;
 	border-width: 2px;
  	background-color: #ff9593;
  	border-style: solid;
  	border-radius: 10px;
    height: 25px;
    font-size: 13px;
    font-weight: 300;
    color: white;
    border: 0px;
}
.post_list{
	padding-top: 40px;
}
.boardcss_list_table { 
	width: 100%; 
}
.list_table { 
	width: 100%; 
}
.list_table thead th { 
	text-align: center; 
	border-top: 1px solid #e5e5e5; 
	border-bottom: 1px solid #e5e5e5; 
	padding: 8px 0; 
	background: #ff9593; 
	color: white;
}

.list_table tbody td { text-align: center;  border-bottom: 1px solid #e5e5e5; padding: 5px 0; }

.postTitle{
	text-decoration: none;
	font-weight: bold; 
	font-size: 16px;
	color: black;
}

</style>
<body>
<div>
	<button style="float:right; margin-right:45px;">검색</button>
    <input type="text" placeholder="검색어를 입력하세요." style="float:right; margin-right:5px;">
</div>

<div class="post_list">
	<table class="list_table">
		<colgroup>
			<col width="15%" />
			<col width="45%" />
			<col width="20%" />
			<col width="20%" />
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>이름</th>
				<th>등록일자</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="post" items="${postList}">
				<tr>
					<td>${post.getPostId()}</td>
					<td><a href = "<c:url value='/community/view'>
                  				<c:param name='post_id' value='${post.getPostId()}'/>
                 			</c:url>" class = "postTitle">${post.getPostTitle()}</a></td>
					<td>${post.getCustId()}</td>
					<td>${post.getPostDate()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>