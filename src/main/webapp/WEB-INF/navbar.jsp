<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</style>
	<header>
      <a href="../../index.jsp">
         <img src="../../images/banner.jpg" style="width:100%">
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
  

 	
