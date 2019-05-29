<%@page contentType="text/html;charset=utf-8" import="java.util.*,ljh.board.model.BoardDTO"%>
	<meta charset='utf-8'>
	<link rel='stylesheet' type='text/css' href='../css/addr.css'>
	<center>
	<body bgcolor='#fcffc6'>
	<body style="text-align:center">
	<h1>
	First Project Index
	</h1>
		<h2>게시판이다(MV)</h2>
		<a href='board.do?m=in_form'>글쓰기</a>
		<hr width='700' size='2' noshade>
		</center>
		<table border='1' width='700' align='center' cellpadding='2'>
		<tr>
		<th align='center' width='10%'>글번호</th>
		<th align='center' width='15%'>작성자</th>
		<th align='center' width='30%'>이메일</th>
		<th align='center' width='30%'>글제목</th>
		<th align='center' width='20%'>날짜</th>
		</tr>
	<%
		ArrayList<BoardDTO> listB =(ArrayList<BoardDTO>)request.getAttribute("listB");
		for(BoardDTO dto : listB){
	%>
				<tr>
				<td align='center'><%=dto.getSeq()%></td>
				<td align='center'><%=dto.getWriter()%></td>
				<td align='center'><%=dto.getEmail()%></td>
				<td align='center'>
				<a href='board.do?m=content&seq=<%=dto.getSeq()%>'><%=dto.getSubject()%></a>
				</td>
				<td align='center'><%=dto.getRdate()%></td>
				</tr>
				<%
		}
		%>