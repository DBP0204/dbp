<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>클래스 개설 폼</title>
<script>
function classCreate() {	
	form.submit();
}

function classList(targetUri) {
	form.action = targetUri;
	form.submit();
}
</script>
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
   tr{
      height : 30px;
   }
   .form-control{
      width: 1000px;
   }
   #c_summary{
      height: 80px;
   }
   #c_details{
      height: 300px;
   }
   .btn{
      padding-top: 30px;
      padding-right: 130px;
      text-align: right;
   }
   .btnOpen{ 
      width: 100px;
       text-align: center;
       border-width: 2px;
        background-color: #ff9593;
        border-style: solid;
        border-radius: 10px;
       height: 40px;
       font-size: 13px;
       font-weight: 300;
       color: white;
       border: 0px;
   }
   
</style>
<script type="module" src="/tag_create.js"></script>
</head>
<body>
   <form name="form" method="POST" action="<c:url value='/class/open'/>">
      <table>
         <tr>   
              <td><label for="cate_name" class="col-lg-2 col-form-label">카테고리</label></td>
              <td>
                  <select name="category">
                    <option value="0">액티비티</option>
                   <option value="1">요리/베이킹</option>
                   <option value="2">공예/DIY</option>
                   <option value="3">미술/드로잉</option>
                   <option value="4">등산/트래킹</option>
                   <option value="5">캠핑</option>
                   <option value="6">뷰티</option>
                 </select>
              </td>
          </tr> 
         <tr>   
              <td><label for="c_name" class="col-lg-2 col-form-label">클래스명</label></td>
              <td><input type="text" name="c_name" class="form-control" placeholder="클래스명"> 
			  </td>
          </tr>  
           <tr>   
              <td><label for="c_price" class="col-lg-2 col-form-label">가격</label></td>
              <td>
                 <input type="text" name="c_price" class="form-control" placeholder="가격">
             </td>  
          </tr>  
          <tr>   
              <td><label for="c_personnel" class="col-lg-2 col-form-label">모집인원</label></td>
              <td><input type="text" name="c_personnel" class="form-control" placeholder="모집인원"></td> 
          </tr>   
          <tr>   
              <td><label for="c_date" class="col-lg-2 col-form-label">수업 날짜</label></td>
              <td><input type="text" name="c_date" class="form-control"></td> 
          </tr>  
          <tr>   
              <td><label for="c_isOnline" class="col-lg-2 col-form-label">온라인/오프라인</label></td>
              <td>
                 <select name="c_isOnline">
                   <option value="0">오프라인</option>
                   <option value="1">온라인</option>
                 </select>
              </td> 
          </tr>  
          <tr>   
              <td><label for="c_local" class="col-lg-2 col-form-label">지역</label></td>
              <td>
                 <select name="c_local">
                   <option value="0">서울</option>
                   <option value="1">경기</option>
                 </select>
              </td> 
          </tr>  
         <tr>   
              <td><label for="c_summary" class="col-lg-2 col-form-label">요약</label></td>
              <td>
                 <input type="text" name="c_summary" id = "c_summary" class="form-control" placeholder="요약">
             </td>  
          </tr> 
          <tr>   
              <td><label for="c_details" class="col-lg-2 col-form-label">상세정보</label></td>
              <td>
                 <input type="text" name="c_details" id = "c_details" class="form-control" placeholder="상세정보">
             </td>  
          </tr>  
          <tr>   
              <td><label for="c_file" class="col-lg-2 col-form-label">파일</label></td>
              <td>
                 <input type="file" name="c_file">
             </td>  
          </tr>    
      </table>
   </form>
   <div class = "btn"><button type="button" class="btnOpen" onClick="classCreate()">클래스 개설</button></div> 
    
</body>
</html>