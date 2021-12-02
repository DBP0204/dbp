<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Funding Participation</title>
<script src="jquery-3.6.0.min.js"></script>
<script>  
   $(document).ready(function() {
     $("#panel").click(function() {
       $("#panel").slideUp("fast");
     });
     $("#slide").click(function() {
       $("#panel").slideDown(1000);
     });
     $("#flip").click(function() {
       $("#panel").slideToggle("slow");
     });
   });

    function participate() {
      alert ("펀딩에 참여하시겠습니까?");  
   }
    function getURL() {
        alert("The URL of this page is: " + window.location.href + "친구에게 공유하시겠습니까?");
    }
    
</script> 
</head>
<style>
	.state-box{
	   width: 300px;
	}
	tr{
	   width: 1500px;
	   height: 100px;
	}
	.img{
	   width: 600px;
	   height: 300px;
	   
	}
	.Funding_image{
	   width: 600px;
	   height: 400px;
	}
	.info{
	   width: 400px;
	   height: 400px;
	}
	.title-info{
	   font-size: 15px;
	    font-weight: 700;
	    color: #5d5f63;
	}
	.remaining-day{
	   text-align: right; 
	   padding-right: 15px;
	   font-size: 20px;
	    font-weight: 700;
	    color: #ff9593;
	}
	.none{
	    display: block;
	    background-color: #ff9593;
	    width: 20%;
	    height: 2px;
	    margin-top: 10px;
	    margin-bottom: 10px;
	}
	.FundingState{
	   font-size: 17px;
	}
	
	.funding-participate{
	   border-radius: 5px;
	   width: 80%;
	    text-align: center;
	    background-color: #ff9593;
	    height: 48px;
	    font-size: 17px;
	    font-weight: 600;
	    color: white;
	    border: 0px;
	}
	.funding-share{
	   border-radius: 5px;
	   width: 15%;
	    text-align: center;
	    background-color: #ff9593;
	    height: 48px;
	    font-size: 17px;
	    font-weight: 600;
	    color: white;
	    border: 0px;
	}
	#slide, #panel, #flip {
	    padding: 5px;
	    text-align: center;
	    background-color: #ff9593;
	    border: solid 1px #c3c3c3;
	}
	#panel {
	    padding: 70px;
	    display: none;
	    height: 00px;
	    background-color: white;
	}

</style>
<body>
<div class="Funding-info">
   <table>
      <tr>
         <td class = "img">
            <img class="Funding_image" src = "https://www.moduba.com/wp-content/uploads/2017/12/Screen-Shot-2017-12-04-at-7.52.00-AM.png">
         </td>
         <td class = "info">
            <div class="Fundingheader">
               <p class="title-info"><em>기타</em></p>
               <h2 class="title">새터민 아이들에게 보내는 레고키트</h2>
            </div>
         <div class="FundingState">
            <p class="remaining-day">D - 6</p>
            <span class = "none" style="width: 95%;"></span>
            <p class="achievement-amount">목표금액 <strong>1,000,000</strong>원</p>
               <p class="achievement-rate"><strong>73</strong>% 달성</p>
               <p class="total-amount"><strong>145,620</strong>원 펀딩</p>
               <p class="total-supporter"><strong>263</strong>명의 서포터</p>
         </div>
         <div class="btn">
            <span><button class="funding-participate" onclick="participate();">펀딩하기</button></span>
            <span><button class="funding-share" onclick="getURL()">공유</button></span>
            </div>
           </td>
        </tr>
        <tr>
         <td colspan ="2">
            <div id="slide">상세정보 보기</div>
                 <div id="panel">
             상세정보 더보기
                 </div>
                 <div id="flip">닫기</div>
           </td>
        </tr>
   </table>
   
</div>

</body>
</html>