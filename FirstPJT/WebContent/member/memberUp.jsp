<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,ljh.addr.model.AddrDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="../css/addr.css">
<link rel="stylesheet" type="text/css" href="../css/navst.css">
<center>
<title>First MProject Index</title>
<h2>회 원 가 입</h2>


</head>
			<nav id="tabs" >
				<div class="tabs">
				<label><a href="../member.do?m=home">Home</a></label>
				<label><a href="">아직미구현임</a></label>
				<label><a href="">아직미구현임</a></label>
				<label><a href="../fileboard/boardlist.jsp">게쉬판</a></label>
			</div>
		</nav>
<body>
	
	
	<form name="f" action="../member.do?m=mAdd" method="post">
       <table border="1" width="400" height="200">
	      <tr>
		     <td width="30%" colspan="2" align="center"><h2>LOGIN</h2></td> 
		  </tr>
		  <tr>
		     <th width="30%">닉네임</th> 
			 <td><input name="nick" align="center" size="20" align="center" disabled></td>
		  </tr>
		  <tr>
		     <th width="30%">I D</th> 
			 <td><input name="id" size="20" align="center" disabled></td>
		  </tr>
		  <tr>
		     <th width="30%">PWD</th> 
			 <td><input name="pwd" size="20" align="center"></td>
		  </tr>
		  <tr>
		     <th width="30%">이 름</th> 
			 <td><input name="name" size="20" align="center" disabled></td>
		  </tr>
		  <tr>
		     <th width="30%">이메일</th> 
			 <td><input name="email" size="30" align="center"></td>
		  </tr>
		  <tr>
		     <th width="30%">연락처</th> 
			 <td><input name="phone" size="30" align="center"></td>
		  </tr>
		  <tr>
		     <th width="30%">주 소</th> 
			 <td><input name="address" size="40" align="center"></td>
		  </tr>
		  <tr>
		     <td colspan="2" align="center">
			     <input type="submit" value="회원가입"/>
				 <input type="reset" value="다시입력"/>
			 </td> 
		  </tr>
	   </table>
	  <a href='../member.do?m=home'>HOME</a>
	  &nbsp;&nbsp;
	   <a href='../'>회원가입</a>
   </form>
</center>
</body>
</html>