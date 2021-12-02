<%@page contentType="text/html; charset=utf-8" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   ClassDTO class_ = (ClassDTO)request.getAttribute("c_id");
%>
<!DOCTYPE html>
<html>
<head>
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
   #tb {
      width: 1000px;
   }
   #d1 {
      height: 30px;
   }
   #d2 {
      height: 50px;
   }
   #s1 {
      font-size: 30px;
      float: left;
   }
   #s2 {
      font-size: 15px;
      float: right;
      padding-top: 10px;
   }
   #d3 {
      font-size: 17px;
   }
   #d4 {
      height: 50px;
      font-size: 20px;
      text-align: right;
   }
   #btn1 {
      width: 220px;
      float: left;
   }
   #btn2 {
      width: 100px;
      float: right;
   }
   #img {
      width: 320px;
      height: 240px;
      margin-left: 30px;
   }
   #info_title, #close {
      text-align: center;
      font-weight: bold;
      font-size: 18px;
      color: white;
      background-color: #ff9593;
   }
   #info {
      text-align: center;
      font-size: 18px;
   }
</style>
<meta charset="UTF-8">
<title>class details</title>
<script>
   function getURL() {
      alert("The URL of this page is: " + window.location.href + "친구에게 공유하시겠습니까?")
   }
   
   $(document).ready(function() {
      $("#info").slideUp("fast");
      $("info_title").click(function() {
         $("#info").slideDown(1000);
         });
      $("#close").click(function() {
         $("#info").slideToggle("slow");
         });
      });
</script>
</head>
<body>
   <table id="tb">
      <tr>
         <td>
            <div id="d2">
               <span id="s1"><%=class_.getC_name()%></span>
               <span id="s2"><%=class_.getC_local()%></span>
            </div>
            <div id="d3"><%=class_.getC_summary()%></div>
            <div id="d4"><p><%=class_.getC_price()%></div>
            <div>
               <span>
                  <button type="button" id="btn1">클래스 참여하기 CLICK!</button>
               </span>
               <span>
                  <button type="button" id="btn2" onclick="getURL()">공유하기</button>
               </span>
            </div>
         </td>
         <td>
            <img src= '${class.c_file}' id="img">
         </td>
      </tr>
      <tr>
         <td colspan="2">
            <div id="info_title">상세정보</div>
            <div id="info"><%=class_.getC_detail()%></div>
            <div id="close">더보기</div>
         </td>
      </tr>
   </table>
</body>
</html>