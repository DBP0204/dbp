<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko-kr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>게시판</title>
<!-- Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
	@font-face {
	    font-family: 'Y_Spotlight';
	    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts-20-12@1.0/Y_Spotlight.woff') format('woff');
	    font-weight: normal;
	    font-style: normal;
	}
	body {
		font-family: 'Y_Spotlight';
	}
	aside {float: left;}
    section {float: left;}
	
	.menu {
		list-style-type: none;
		margin-left:40px;
		margin-right:10px;
		margin-top:10px;
        width: 150px;
	    height: 380px;
		background: #fec1c0;
		overflow: auto;
		text-align:center;		
	}
	div .cate {
		text-decoration: none;
		padding: 15px;
		display: block;
		color: #000;
		font-weight: bold;
		font-size: 18px;
	}
	
	div .cate:hover {
		background: #ff9593;
		color: #ffffff;
	}
	
	div .cate.home {
		background : #ff9593;
		color: #ffffff;
	}
	.td {
		float: right;
		background-color:#000000;
	}
	
</style>
</head>
<body>
	<header>
      <a href="index.jsp">
         <img src="images/banner.jpg" style="width:100%">
      </a>
   </header>
	<nav class="navbar navbar-expand-lg navbar-light bg-light" >
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarText">
	    <ul class="navbar-nav mr-auto">
	      
	    
	      <li class="nav-item">
	        <a class="nav-link" href="<c:url value='/class' />">클래스</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="<c:url value='/meeting' />">모임</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="<c:url value='/funding' />">펀딩</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="<c:url value='/community' />">게시판</a>
	      </li>
	 
	    
	<%if(session.getAttribute("userId") == null) {%>
	
	      <li class="nav-item">
	        <a class="nav-link" href="<c:url value='/user/login/form' />">로그인</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="<c:url value='/user/register/form' />">회원가입</a>
	      </li>
	      
	       
	<%
	}
	else 
	{  
	%>
	       <li class="nav-item">
	        <a class="nav-link" href="<c:url value='/user/logout' />">로그아웃 </a>
	      </li>
	<%
	} %>
	     
	    </ul>
	  </div>
	</nav>
	<div>
    <h1 style="margin-left:82px; margin-top:40px">게시판</h1>
    <aside>
    	<div class = "menu">
		    <div style="top:100px"><a class = "cate" href="<c:url value='/community/list' />" target="firsti">전체보기</a></div><br>
			<div style="top:150px"><a class = "cate" href="<c:url value='/community/write/form' />" target="firsti">게시글 작성</a></div><br>
    	</div>
    </aside>
    <section>
        <iframe src="<c:url value='/community/list' />" width=1280 height=1700 name=firsti frameborder="0"></iframe>
    </section>
	</div>
	
</body>
</html>