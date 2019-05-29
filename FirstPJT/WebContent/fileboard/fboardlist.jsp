<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,ljh.mp.member.model.fboardDTO"%>
<html>
  <head> 
  <%
		String seID = (String)session.getAttribute("session_id");
%>
    <title>게쉬판</title>
  </head>
  <body>
    <center>
	    <font size="5" color="Navy">
	    <h2>First MProject Index</h2>
		  <b>게쉬판</b>
		</font>
		&nbsp;&nbsp;&nbsp;&nbsp;<%= seID %>  님
		<br/>
		<a href="fboard.do?m=write_form">글쓰기</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href='member.do?=home'>메인</a>
		
		<form name="f">
		  <input type="hidden"  name="method" value="list">
		  <select name="ps" onChange="submit()">
<option value="3" selected>페이지 SIZE 선택</option>
<option value=5>페이지 SIZE 5</option>
<option value=10>페이지 SIZE 10</option>
		  </select>
		</form>
		
	  <hr width="700" color="Maroon" size="2" noshade>

	  <table align="center" cellspacing="1" cellpadding="3" 
	                                   width="700" border="1">
		<tr align="center">
		  <td width="10%"><b>순번</b></td>
		  <td width="40%"><b>제목</b></td>
		  <td width="15%"><b>글쓴이</b></td>
		  <td width="15%"><b>날짜</b></td>
		  <td width="20%"><b>조회수</b></td>
		</tr>
		<%
		ArrayList<fboardDTO> listB =(ArrayList<fboardDTO>)request.getAttribute("listB");
		for(fboardDTO dto : listB){
		%>
	    <tr align="center">
	    	<td width="10%"><%=dto.getIdx()%></td>
			<td width="40%" align="left">
				<a href="fboard.do?m=content&idx=<%=dto.getIdx()%>"><%=dto.getSubject()%><a>
			</td>
			<td width="15%"><%=dto.getWriter()%></td>
			<td width="20%"><%=dto.getWritedate()%></td>
			<td width="20%"><%=dto.getReadnum()%></td>
		</tr>
		<%
		}
		%>
			<td colspan="5">
		    <hr width="700" color="Maroon" size="2" noshade>
		  	</td>
		</tr>
		<tr>
		  <td colspan="3" align="center">

             <a href="rb-list.do?method=list&cp=13&ps=3">
                ◀이전
			 </a>

           |

             <a href="rb-list.do?method=list&cp=1&ps=3">
1

             </a> 

             <a href="rb-list.do?method=list&cp=2&ps=3">
2

             </a> 

             <a href="rb-list.do?method=list&cp=3&ps=3">
3

             </a> 

             <a href="rb-list.do?method=list&cp=4&ps=3">
4

             </a> 

             <a href="rb-list.do?method=list&cp=5&ps=3">
5

             </a> 

             <a href="rb-list.do?method=list&cp=6&ps=3">
6

             </a> 

             <a href="rb-list.do?method=list&cp=7&ps=3">
7

             </a> 

             <a href="rb-list.do?method=list&cp=8&ps=3">
8

             </a> 

             <a href="rb-list.do?method=list&cp=9&ps=3">
9

             </a> 

             <a href="rb-list.do?method=list&cp=10&ps=3">
10

             </a> 

             <a href="rb-list.do?method=list&cp=11&ps=3">
11

             </a> 

             <a href="rb-list.do?method=list&cp=12&ps=3">
12

             </a> 

             <a href="rb-list.do?method=list&cp=13&ps=3">
13

             </a> 

             <a href="rb-list.do?method=list&cp=14&ps=3">
<b>14</b>

             </a> 

		   |

			 &nbsp;&nbsp;&nbsp; 
			14page/14pages
		  </td>
		  <td colspan="2" align="center">
		    총 게시물 수 : 42
		  </td>
		</tr>
	  </table>
	  <hr width="700" color="Maroon" size="2" noshade>
	</center>
  </body>
</html>

</html>