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
      <td>����</td>
      <td><input type="text"></td>
    </tr>
    <tr>
      <td>ī�װ�</td>
      <td><select name="category">
        <option value="cooking">�丮</option>
        <option value="handicraft">������</option>
        <option value="flower">�ö��</option>
        <option value="art">�̼�</option>
        <option value="activity">��Ƽ��Ƽ</option>
        <option value="beauty">��Ƽ</option>
      </select></td>
    </tr>
    <tr>
      <td>����</td>
      <td><select name="area1">
        <option>-����-</option>
        <option value='1'>����</option>
        <option value='2'>�λ�</option>
        <option value='3'>�뱸</option>
        <option value='4'>��õ</option>
        <option value='5'>����</option>
        <option value='6'>����</option>
        <option value='7'>���</option>
        <option value='8'>����</option>
        <option value='9'>���</option>
        <option value='10'>�泲</option>
        <option value='11'>���</option>
        <option value='12'>����</option>
        <option value='13'>����</option>
        <option value='14'>����</option>
        <option value='15'>�泲</option>
        <option value='16'>���</option>
      </select></td>
    </tr>
    <tr>
      <td>�ִ� ���� �ο�</td>
      <td><input type="number" name="personnel" min="1" max="100"></td>
    </tr>
    <tr>
      <td>��� ����</td>
      <td><textarea name="class_summary" rows="8" cols="80"></textarea></td>
    </tr>
    <tr>
      <td>�� ����</td>
      <td><textarea name="class_details" rows="8" cols="80"></textarea></td>
    </tr>
    <tr>
      <td>�±�</td>
      <td><input type="text" id="tag" size="20" placeholder="�±��Է�" /></td>
    </tr>
    <tr>
      <td colspan="2"><ul id="tag-list"></ul></td>
    </tr>
  </table>
  <input type="submit" value="���">
  </form>
</body>
</html>