<%@ page language="java" contentType="text/html; charset=utf-8" import="java.io.*,ljh.mp.member.model.fboardDTO"%>
<link rel="stylesheet" type="text/css" href="http://image.lgeshop.com/css/style_2005.css">
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
		  <a href="fboard.do">목록</a>
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <a href='member.do?m=home'>메인</a>
		  
	  <hr width="600" color="Maroon" size="2" noshade>
<%
	fboardDTO dto = (fboardDTO) request.getAttribute("listC");
%>

	  <table align="center" width="600" cellspacing="1" 
	                          cellpadding="3" border="1" id="table">
		<tr>
		  <td align="center" width="15%"><b>순번</b></td>
		  <td align="center" width="35%"><%=dto.getIdx()%></td>
		  <td align="center" width="15%"><b>날짜</b></td>
		  <td align="center" width="35%"><%=dto.getWritedate()%></td>
		</tr>
		<tr>
		  <td align="center" width="15%"><b>글쓴이</b></td>
		  <td align="center" width="35%"><%=dto.getWriter()%> </td>
		  <td align="center" width="15%"><b>HomePage</b></td>
		  <td align="center" width="35%"><%=dto.getHomepage()%></td>
		</tr>
		<tr>
		  <td colspan="3">&nbsp;</td>
		  <td><b>조회수</b><%=dto.getReadnum()%></td>
		</tr>
		<tr>
		  <td colspan="2"><b>제목</b><%=dto.getSubject()%></td>
		  <td colspan="2"><b>첨부파일</b><%=dto.getFilename()%></td>
		</tr>
		<tr>
		  <td colspan="4"><%=dto.getContent()%> </td>
		</tr>

		<tr>
		  <td colspan="4" align="center">
		    <hr width="550" color="Maroon" size="2" noshade>
			<!----------------- re 변화 2 ---------------->
			<a href="fboard.do">목록</a> | 
			<a href="fboard.do?m=Conup">편집</a> | 
			<a href="fboard.do?m=del">삭제</a> | 
			<a href="">답변</a>
		    <!-- <a href=
	"reboard_rewrite.jsp?idx=13&ref=9&lev=0&sunbun=0&cp=1">
			  답변
		    </a> -->
			
			<!-------------------------------------------->
		  </td>
		</tr>
		<tr align="center" id="ta">
		  <td>
		     리플달기 
		  </td>

          <script language="javascript">
              loginJs = false;
              function check()
              {
                  if(!loginJs)
                  {
                      yesNo = confirm(
                         "먼저 로그인을 하셔야 합니다. 로그인 페이지로 이동할까요?");
                      if(yesNo)
                      {
                         location.href="/M2Project/login.do";
  
                      }
                      
                      return;
                  }
                  else
                  {
                      if(f1.content_reply.value == "" || f1.pwd_reply.value == "")
	                  {
	                      alert("리플 내용과 비밀번호를 모두 입력하셔야 합니다.");
	                      return;
	                  }
                  	  f1.submit();
                  }
              }
          </script>
		  <form name="f1" action="fboard.do?m=re&writer=<%= seID %>&idx=<%=dto.getIdx()%>">
			  <td colspan="3">
			     <input type="hidden" name="method" value="replySave">
				 <input type="text" name="content_reply" size="70">
				 &nbsp;&nbsp;비밀번호
				 <input type="text" name="pwd_reply" size="10">
				 <input type="button" value="등록" onclick="check()">
			  </td>
		  </form>
		</tr>
	  </table>
	  
	  <br><hr width="600" color="Maroon" size="2" noshade><br>
	  
	  
<script language="javascript">     
      function replyDelCheck(idx_reply)
      {
          //alert("loginJs : " + loginJs);
          //alert("idx_reply : " + idx_reply);
          if(!loginJs) //로그인 안함 
          {
             
             alert("로그인 or 리플의 비밀번호를 입력하셔야 합니다.");
             yesNo = confirm("로그인을 하시겠습니까?");
             if(yesNo)
             {
                  location.href="/M2Project/login.do";   
      
             }
             else
             {
                   pwd_reply = prompt("리플 비밀번호를 입력해주세요..");
                   location.href ="/M2Project/rb-reply-del.do?method=replyDel"
                        +"&idx_reply="+idx_reply+"&pwd_reply="+pwd_reply;
             }
          }
          else  // 로그인 함 
          {
               location.href ="/M2Project/rb-reply-del.do?method=replyDel"
                        +"&idx_reply="+idx_reply;
          }
      }
</script>
      <table align="center" width="600" cellspacing="1" 
	                          cellpadding="3" border="1"> 
		 <tr align="center">
		     <td colspan="2">
			    <font color="red"><b>R E P L Y</b></font>
			 </td>
		 </tr>


	  </table>
	</center>
  </body>
</html>