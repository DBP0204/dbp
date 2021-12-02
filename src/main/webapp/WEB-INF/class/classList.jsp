<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ClassList</title>
</head>
<style>
	.classHead{
	}
   .Class_image{
      width: 300px;
      height: 200px;
   }
   .title{
      text-decoration: none;
      font-weight: bold; 
      font-size: 16px;
      color: black;
   }
   .item_info{
      font-size: 14px;
      color: #5d5f63;
   }
   .Class_local{
      float : left;
      padding-right: 15px;
   }
   .none{
       display: block;
       background-color: #ff9593;
       width: 20%;
       height: 2px;
      margin-top: 10px;
         margin-bottom: 10px;
   }
   .Class_price{
      float : right;
      padding-right: 15px;
      font-size: 18px;
      font-weight: bold;
      color: #5d5f63;
   }
   
</style>
<body>
<table style="width:100%">
	<tr>
		<td width="20"></td>
		<td>  
		<br>		  
		<table class="classTable">
		<c:set var="i" value="0" /> 
		<c:set var="j" value="3" /> 
		<table> 
         <c:forEach items="${classList}" var="class"> 
            <c:if test="${i%j == 0 }"> 
               <tr> 
            </c:if> 
                 <td>
					<div class = "ClassItem">
						<div class = "ClassInfo">
							<a href="<c:url value='/class/details'>
                  				<c:param name='c_id' value='${class.c_id}'/>
                 			</c:url>">
								<img class="Class_image" src = '${class.c_file}'>
							</a>
							<p>
							<a href="<c:url value='/class/details' />" class = "title">${class.c_name}</a>
							<div class = "item_info">
								<span class="Class_host"> ${class.c_local}</span>
							</div>
							<span class = "none" style="width: 95%;"></span>
							<span class= "Class_price">${class.c_price}</span>
						</div>
					</div>
				</td> 
            <c:if test="${i%j == j-1}"> 
               </tr> 
            </c:if> 
            <c:set var="i" value="${i+1}" /> 
         </c:forEach> 
		</table>
		</table>
		</td>
	</tr>
</table>
</body>
</html>