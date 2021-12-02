<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Ŭ���� ���� ��</title>
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
              <td><label for="cate_name" class="col-lg-2 col-form-label">ī�װ�</label></td>
              <td>
                  <select name="category">
                    <option value="0">��Ƽ��Ƽ</option>
                   <option value="1">�丮/����ŷ</option>
                   <option value="2">����/DIY</option>
                   <option value="3">�̼�/�����</option>
                   <option value="4">���/Ʈ��ŷ</option>
                   <option value="5">ķ��</option>
                   <option value="6">��Ƽ</option>
                 </select>
              </td>
          </tr> 
         <tr>   
              <td><label for="c_name" class="col-lg-2 col-form-label">Ŭ������</label></td>
              <td><input type="text" name="c_name" class="form-control" placeholder="Ŭ������"> 
			  </td>
          </tr>  
           <tr>   
              <td><label for="c_price" class="col-lg-2 col-form-label">����</label></td>
              <td>
                 <input type="text" name="c_price" class="form-control" placeholder="����">
             </td>  
          </tr>  
          <tr>   
              <td><label for="c_personnel" class="col-lg-2 col-form-label">�����ο�</label></td>
              <td><input type="text" name="c_personnel" class="form-control" placeholder="�����ο�"></td> 
          </tr>   
          <tr>   
              <td><label for="c_date" class="col-lg-2 col-form-label">���� ��¥</label></td>
              <td><input type="text" name="c_date" class="form-control"></td> 
          </tr>  
          <tr>   
              <td><label for="c_isOnline" class="col-lg-2 col-form-label">�¶���/��������</label></td>
              <td>
                 <select name="c_isOnline">
                   <option value="0">��������</option>
                   <option value="1">�¶���</option>
                 </select>
              </td> 
          </tr>  
          <tr>   
              <td><label for="c_local" class="col-lg-2 col-form-label">����</label></td>
              <td>
                 <select name="c_local">
                   <option value="0">����</option>
                   <option value="1">���</option>
                 </select>
              </td> 
          </tr>  
         <tr>   
              <td><label for="c_summary" class="col-lg-2 col-form-label">���</label></td>
              <td>
                 <input type="text" name="c_summary" id = "c_summary" class="form-control" placeholder="���">
             </td>  
          </tr> 
          <tr>   
              <td><label for="c_details" class="col-lg-2 col-form-label">������</label></td>
              <td>
                 <input type="text" name="c_details" id = "c_details" class="form-control" placeholder="������">
             </td>  
          </tr>  
          <tr>   
              <td><label for="c_file" class="col-lg-2 col-form-label">����</label></td>
              <td>
                 <input type="file" name="c_file">
             </td>  
          </tr>    
      </table>
   </form>
   <div class = "btn"><button type="button" class="btnOpen" onClick="classCreate()">Ŭ���� ����</button></div> 
    
</body>
</html>