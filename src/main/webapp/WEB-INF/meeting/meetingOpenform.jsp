<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
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
</head>
<body>
<form action="get">
  <table>
    <tr>
      <td>제목</td>
      <td><input type="text"></td>
    </tr>
    <tr>
      <td>카테고리</td>
      <td><select name="category">
        <option value="cooking">요리</option>
        <option value="handicraft">수공예</option>
        <option value="flower">플라워</option>
        <option value="art">미술</option>
        <option value="activity">액티비티</option>
        <option value="beauty">뷰티</option>
      </select></td>
    </tr>
    <tr>
      <td>지역</td>
      <td><select name="area1">
        <option>-선택-</option>
        <option value='1'>서울</option>
        <option value='2'>부산</option>
        <option value='3'>대구</option>
        <option value='4'>인천</option>
        <option value='5'>광주</option>
        <option value='6'>대전</option>
        <option value='7'>울산</option>
        <option value='8'>강원</option>
        <option value='9'>경기</option>
        <option value='10'>경남</option>
        <option value='11'>경북</option>
        <option value='12'>전남</option>
        <option value='13'>전북</option>
        <option value='14'>제주</option>
        <option value='15'>충남</option>
        <option value='16'>충북</option>
      </select></td>
    </tr>
    <tr>
      <td>최대 모임 인원</td>
      <td><input type="number" name="personnel" min="1" max="100"></td>
    </tr>
    <tr>
      <td>요약 내용</td>
      <td><textarea name="class_summary" rows="8" cols="80"></textarea></td>
    </tr>
    <tr>
      <td>상세 정보</td>
      <td><textarea name="class_details" rows="8" cols="80"></textarea></td>
    </tr>
    <tr>
      <td>태그</td>
      <td><input type="text" id="tag" size="20" placeholder="태그입력" /></td>
    </tr>
    <tr>
      <td colspan="2"><ul id="tag-list"></ul></td>
    </tr>
  </table>
  <input type="submit" value="등록">
  </form>
</body>
</html>