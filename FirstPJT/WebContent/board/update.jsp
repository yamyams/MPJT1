<%@page contentType="text/html;charset=utf-8" import="java.sql.*,ljh.board.model.BoardDTO"%>
<meta charset='utf-8'>
<center>
<body bgcolor='#fcffc6'>
<body style="text-align:center">
<hr width='600' size='2' noshade>
<h1>
	Jaeh's First PJT
</h1>
<%
	BoardDTO dto = (BoardDTO) request.getAttribute("up");
%>
<a href='board.do'>글목록</a>
<hr width='600' size='2' noshade>
<form name='f' method='post' action='board.do?m=up1'>
<input type='hidden' name='seq' value='<%=dto.getSeq()%>'>
<input type='hidden' name='writer' value='<%=dto.getWriter()%>'>
<table border='1' width='600' align='center' cellpadding='3' cellspacing='1'><tr>
<td width='30%' align='center'>글쓴이</td>
<td align='center'><input type='text' name='aa' size='60' value='<%=dto.getWriter()%>' disabled></td>
</tr>
<tr>
<td width='30%' align='center'>이메일</td>
<td align='center'><input type='text' name='email' size='60' value='<%=dto.getEmail()%>'></td>
</tr>
<tr>
<td width='30%' align='center'>글제목</td>
<td align='center'><input type='text' name='subject' size='60' value='<%=dto.getSubject()%>'></td>
</tr>
<tr>
<td width='30%' align='center'>글내용</td>
<td align='center'><textarea name='content' rows='5' cols='53'><%=dto.getContent()%></textarea></td>
</tr>
<tr>
<td colspan='2' align='center'>
<input type='submit' value='수정'>
</td>
</tr>
</table>
</form>
</table>
<hr width='600' size='2' noshade>
<b> 
<a href='board.do?m=del&seq=<%=dto.getSeq()%>'>삭제</a>
| 
<a href='board.do'>목록</a>
</b>
<hr width='600' size='2' noshade>
</center>
