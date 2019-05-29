<%@ page language="java" contentType="text/html; charset=utf-8" %>

<html>
  <head>
  	<meta charset='utf-8'>
	<link rel="stylesheet" type="text/css" href="../css/addr.css">
	<link rel="stylesheet" type="text/css" href="../css/navst.css">
    <title>간단한 게시판</title>
  </head>
  	<body bgcolor='#fcffc6'>
	<body style="text-align:center">
  <body onload="input.name.focus()">
    <center>
	 <h1>
	Jaeh's First PJT
	</h1>

		  <a href='../board.do'>글목록</a>
	   <hr width="600" size="2" noshade>
	</center>
	<form name="input" method="post" action='../board.do?m=in'>
	   <table border="1" width="600" align="center"  cellpadding="3" cellspacing="1">
	      <tr>
		     <td width="30%" align="center">글쓴이</td>
			 <td align="center"><input type="text" name="writer" size="60"></td>
		  </tr>
		  <tr>
		     <td align="center">이메일</td>
			 <td align="center"><input type="text" name="email" size="60"></td>
		  </tr>
          <tr>
		     <td align="center">글제목</td>
			 <td align="center"><input type="text" name="subject" size="60"></td>
		  </tr>
		  <tr>
		     <td align="center">글내용</td>
			 <td align="center"><textarea name="content" rows="5" cols="53"></textarea></td>
		  </tr>
		  <tr>
		     <td colspan="2" align="center">
			    <input type="submit" value="전송">
				<input type="reset" value="다시입력">
			 </td>
		  </tr>
	   </table>
	   <br>
	   <hr width="600" size="2" noshade>
	</form>
  </body>
</html>