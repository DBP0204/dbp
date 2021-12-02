<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		height: 400px;
		width: 700px;
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
<meta charset="EUC-KR">
<title>meeting details</title>
<script src="jquery-3.6.0.min.js"></script>
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
				<div id="d1">#관련 태그1 #관련 태그2 #관련 태그3</div>
				<div id="d2">
					<span id="s1">[지역] 모임 제목</span>
					<span id="s2">카테고리</span>
				</div>
				<div id="d3">모임 요약. 이곳에다가 간단한 모임 소개를 쓰면 됩니다. (호스트 소개, 모임 소개 등)</div>
				<div id="d4"><p>참여비 : 10000원</div>
				<div>
					<span>
						<button type="button" id="btn1">모임 참여하기 CLICK!</button>
					</span>
					<span>
						<button type="button" id="btn2" onclick="getURL()">공유하기</button>
					</span>
				</div>
			</td>
			<td>
				<img src="images/1.jpg" id="img">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<div id="info_title">상세정보</div>
				<div id="info">안녕하세요.</div>
				<div id="close">더보기</div>
			</td>
		</tr>
	</table>
</body>
</html>