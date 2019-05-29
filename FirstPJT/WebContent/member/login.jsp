<%@ page language="java" contentType="text/html; charset=utf-8" %>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="../css/addr.css">
<link rel="stylesheet" type="text/css" href="../css/navst.css">
<script src="./js/trim.js"></script>
<script language="javascript">
 function check(){
   	   var idval = f.id.value;
   			idval = trim(idval);
   	   if(idval.length == 0){
   		   alert("아이디를 입력해");
   		   f.id.value = "";
   		   f.id.focus();
   		   return false;
   	   }else{
   		   isOver = checkByteLen(idval, 30);
   		   if(isOver){
   			   alert("아이디가 너무 길어");
   			   f.id.focus();
    		   return false;
   		   }
   	   }
   	   
   	   var pwdrval = f.pwd.value;
   			pwdrval = trim(addrval);
	   if(pwdrval.length == 0){
		   alert("비밀번호를 입력해");
		   f.pwd.value = "";
		   f.pwd.focus();
		   return false;
	   }else{
		   isOver = checkByteLen(pwdrval, 30);
		   if(isOver){
			   alert("비밀번호가 너무 길어");
			   f.pwd.focus();
 		   	   return false;
		   }
	   }
   	   
   	   f.submit();
   }
 </script>
 <center>
 <h1>
		LOGIN PAGE
   </h1>
<body onload="document.f.name.focus()">
			<nav id="tabs" >
				<div class="tabs">
				<label><a href="../member.do?m=home">Home</a></label>
				<label><a href="">아직미구현임</a></label>
				<label><a href="">아직미구현임</a></label>
				<label><a href="board.do?=fboardlist">게쉬판</a></label>
			</div>
		</nav>
<%

%>
  
   <form name="f" action="../member.do?m=login" method="post">
       <table border="1" width="300" height="200">
	      <tr>
		     <td width="30%" colspan="2" align="center"><h2>LOGIN</h2></td> 
		  </tr>
		  <tr>
		      <th width="30%">아이디</th> 
			 <td><input name="id" align="center" size="20" align="center"></td>
		  </tr>
		  <tr>
		     <th width="30%">비밀번호</th> 
			 <td><input name="pwd" size="20" align="center"></td>
		  </tr>
		  <tr>
		     <td colspan="2" align="center">
			     <input type="submit" value="로그인"/>
				 <input type="reset" value="다시입력"/>
			 </td> 
		  </tr>
	   </table>
	  <a href='../member.do?m=home'>HOME</a>
	  &nbsp;&nbsp;
	   <a href='../member.do?m=mAdd_form'>회원가입</a>
   </form>
</center>
</body>
  
