<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FundingList</title>
</head>
<style>
	td {
	   width: 350px;
	   height: 300px;
	}
	.Funding_image{
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
	.Funding_category{
	   float : right;
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
	.Funding_percent{
	    color: #ff9593;
	    font-size: 15px;
	    font-weight: 700;
	}
	.Funding_amount{
	   font-size: 14px;
	   color: #5d5f63;
	}
	.Funding_day{
	   float : right;
	   padding-right: 15px;
	   font-size: 15px;
	    font-weight: 700;
	    color: #5d5f63;
	
	}
</style>
<body>
<div class = "FundingContainer">
   <div class = "FundingList">
      <table>
         <tr>
            <td>
               <div class = "FundingItem">
                  <div class = "FundingInfo">
                      <a href="fundingDetails.jsp">
                        <img class="Funding_image" src = "https://www.moduba.com/wp-content/uploads/2017/12/Screen-Shot-2017-12-04-at-7.52.00-AM.png">
                     </a>
                     <p>
                     <a href = "fundingDetails.jsp" class = "title">새터민 아이들에게 보내는 레고키트</a>
                     <div class = "item_info">
                        <span class="Funding_host"> 주식회사 한독</span>
                        <span class="Funding_category">기타</span>
                     </div>
                     <span class = "none" style="width: 95%;"></span>
                     <span class= "Funding_percent">73%</span>
                     <span class= "Funding_amount">145,620원</span>
                     <span class= "Funding_day">
                        <span class= "Funding_remainingDayText">D -</span>
                        <span class= "Funding_remainingDay">10</span>
                        <span class= "Funding_isAchieve"></span>
                     </span>
                  </div>
               </div>
            </td>
            <td>
               <div class = "FundingItem">
                  <div class = "FundingInfo">
                      <a href="fundingDetails.jsp">
                        <img class="Funding_image" src = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGgwYO3JCFxbJ2bWStlDj3vIaBYPHvSjVuTg&usqp=CAU">
                     </a>
                     <p>
                     <a href = "fundingDetails.jsp" class = "title">요양원에 보내는 비누만들기 키트</a>
                     <div class = "item_info">
                        <span class="Funding_host">행복요양원</span>
                        <span class="Funding_category">공예</span>
                     </div>
                     <span class = "none" style="width: 95%;"></span>
                     <span class= "Funding_percent">342%</span>
                     <span class= "Funding_amount">1,711,000원</span>
                     <span class= "Funding_day">
                        <span class= "Funding_remainingDayText">D -</span>
                        <span class= "Funding_remainingDay">6</span>
                        <span class= "Funding_isAchieve"></span>
                     </span>
                  </div>
               </div>               
            </td>
            <td>
               <div class = "FundingItem">
                  <div class = "FundingInfo">
                      <a href="fundingDetails.jsp">
                        <img class="Funding_image" src = "https://www.moduba.com/wp-content/uploads/2017/12/Screen-Shot-2017-12-04-at-7.52.00-AM.png">
                     </a>
                     <p>
                     <a href = "fundingDetails.jsp" class = "title">새터민 아이들에게 보내는 레고키트</a>
                     <div class = "item_info">
                        <span class="Funding_host"> 주식회사 한독</span>
                        <span class="Funding_category">푸드</span>
                     </div>
                     <span class = "none" style="width: 95%;"></span>
                     <span class= "Funding_percent">342%</span>
                     <span class= "Funding_amount">1,711,000원</span>
                     <span class= "Funding_day">
                        <span class= "Funding_remainingDayText">D -</span>
                        <span class= "Funding_remainingDay">6</span>
                        <span class= "Funding_isAchieve"></span>
                     </span>
                  </div>
               </div>
            </td>
         </tr>
         <tr>
            <td>
               <div class = "FundingItem">
                  <div class = "FundingInfo">
                      <a href="fundingDetails.jsp">
                        <img class="Funding_image" src = "https://www.moduba.com/wp-content/uploads/2017/12/Screen-Shot-2017-12-04-at-7.52.00-AM.png">
                     </a>
                     <p>
                     <a href = "fundingDetails.jsp" class = "title">새터민 아이들에게 보내는 레고키트</a>
                     <div class = "item_info">
                        <span class="Funding_host"> 주식회사 한독</span>
                        <span class="Funding_category">기타</span>
                     </div>
                     <span class = "none" style="width: 95%;"></span>
                     <span class= "Funding_percent">73%</span>
                     <span class= "Funding_amount">145,620원</span>
                     <span class= "Funding_day">
                        <span class= "Funding_remainingDayText">D -</span>
                        <span class= "Funding_remainingDay">10</span>
                        <span class= "Funding_isAchieve"></span>
                     </span>
                  </div>
               </div>
            </td>
            <td>
               <div class = "FundingItem">
                  <div class = "FundingInfo">
                      <a href="fundingDetails.jsp">
                        <img class="Funding_image" src = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGgwYO3JCFxbJ2bWStlDj3vIaBYPHvSjVuTg&usqp=CAU">
                     </a>
                     <p>
                     <a href = "fundingDetails.jsp" class = "title">요양원에 보내는 비누만들기 키트</a>
                     <div class = "item_info">
                        <span class="Funding_host">행복요양원</span>
                        <span class="Funding_category">공예</span>
                     </div>
                     <span class = "none" style="width: 95%;"></span>
                     <span class= "Funding_percent">342%</span>
                     <span class= "Funding_amount">1,711,000원</span>
                     <span class= "Funding_day">
                        <span class= "Funding_remainingDayText">D -</span>
                        <span class= "Funding_remainingDay">6</span>
                        <span class= "Funding_isAchieve"></span>
                     </span>
                  </div>
               </div>               
            </td>
            <td>
               <div class = "FundingItem">
                  <div class = "FundingInfo">
                      <a href="fundingDetails.jsp">
                        <img class="Funding_image" src = "https://www.moduba.com/wp-content/uploads/2017/12/Screen-Shot-2017-12-04-at-7.52.00-AM.png">
                     </a>
                     <p>
                     <a href = "fundingDetails.jsp" class = "title">새터민 아이들에게 보내는 레고키트</a>
                     <div class = "item_info">
                        <span class="Funding_host"> 주식회사 한독</span>
                        <span class="Funding_category">푸드</span>
                     </div>
                     <span class = "none" style="width: 95%;"></span>
                     <span class= "Funding_percent">342%</span>
                     <span class= "Funding_amount">1,711,000원</span>
                     <span class= "Funding_day">
                        <span class= "Funding_remainingDayText">D -</span>
                        <span class= "Funding_remainingDay">6</span>
                        <span class= "Funding_isAchieve"></span>
                     </span>
                  </div>
               </div>
            </td>
         </tr>
      </table>   
   </div>
</div>
</body>
</html>