<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="EUC-KR">
<title>슬기로운 취미생활</title>
<style>
   .container {
     position: absolute;
     width : 100%
   }
   table {
      width : 100%
      
   }
   .container .btn {
     position: absolute;;
     top: 50%;
     left: 95%;
     transform: translate(-70%, -70%);
     -ms-transform: translate(-70%, -70%);
     background-color: #5fbee3;
     color: white;
     font-size: 16px;
     padding: 12px 24px;
     border: none;
     cursor: pointer;
     border-radius: 5px;
     text-align: center;
   }
   @font-face {
          font-family: 'Y_Spotlight';
          src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts-20-12@1.0/Y_Spotlight.woff') format('woff');
          font-weight: normal;
          font-style: normal;
      }
   body {
      font-family: 'Y_Spotlight';
   }
   .detail {
      background-color : #e8e8e8;
      padding: 20px 0px 30px 100px;
   }
   .image {
      position:relative;
      margin: 50px;
   }
   .login {
      text-decoration-line:none;
      font-size:20px;
      
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
<div class="image" align="center">
	<a href="<c:url value='/class' />">
		<img src="images/1.jpg" style="margin-right:10px">
	</a>
	<a href="<c:url value='/meeting' />">
		<img src="images/2.jpg" style="margin-right:10px">
	</a>
	<a href="<c:url value='/funding' />">
		<img src="images/3.jpg" style="margin-right:10px">
	</a>
	<a href="<c:url value='/community' />">
		<img src="images/4.jpg">
	</a>     
</div>
  <div class="detail">
      <br>(주) 슬기로운 취미생활
      <br>대표 : 일제삼피
      <br>서울특별시 성북구 화랑로 13길 60
      <br>이메일 : wh@wisehobby.com
      <p>
      <br>copyright 2021. WH. All rights reserved.
   </div>
</body>
</html>
