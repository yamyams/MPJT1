<%@page contentType="text/html;charset=utf-8" import="java.sql.*,ljh.board.model.BoardDTO"%>
	<meta charset='utf-8'>
	<link rel='stylesheet' type='text/css' href='../css/addr.css'>
	<link rel='stylesheet' type='text/css' href='../css/navst.css'>
	<center>
	<body bgcolor='#fcffc6'>
	<body style="text-align:center">
	<h1>
	Jaeh's First PJT(MV)
	</h1>
		<a href='board.do?m=in_form''>글쓰기</a>
		<hr width='600' size='2' noshade>
		<table border='1' width='600' align='center' cellpadding='3'>
	<%
	BoardDTO dto = (BoardDTO) request.getAttribute("content");
			%>
			<td width='100' align='center'>글번호</td>
			<td><%=dto.getSeq()%></td>
			</tr>
			<td align='center'>글쓴이</td>
			<td><%=dto.getWriter()%></td>
			</tr>
			<tr>
			<td align='center'>이메일</td>
			<td><%=dto.getEmail()%></td>
			</tr>
			<tr>
			<td align='center'>글제목</td>
			<td><%=dto.getSubject()%></td>
			</tr>
			<tr>
			<td align='center'>글내용</td>
			<td><%=dto.getContent()%></td>
			</tr>
			</table>
			<hr width='600' size='2' noshade>
			<b>
			<a href='board.do?m=up&seq=<%=dto.getSeq()%>'>수정</a>
			| 
			<a href='board.do?m=del&seq=<%=dto.getSeq()%>'>삭제</a>
			| 
			<a href='board.do'>목록</a>
			</b>
			<hr width='600' size='2' noshade>
			</center>
			<%

		
		%>