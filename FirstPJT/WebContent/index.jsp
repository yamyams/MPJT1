<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="./css/addr.css">
<link rel="stylesheet" type="text/css" href="./css/navst.css">
<center>
<title>First MProject Index</title>
<%
		String seID = (String)session.getAttribute("session_id");
%>

<h2>First MProject Index</h2>
<% 
	if(seID != null){ 
%>
	<%=seID %>  님 
<%
	}else	{
%>
	<a href="member.do?m=login_form">로그인</a> 해주세요
<%
	}
%>
</head>
		<nav id="tabs" >
			<div class="tabs">
				<label><a href="member.do?m=home">Home</a></label>
				<label><a href="">아직미구현임</a></label>
				<label><a href="">아직미구현임</a></label>
				<label><a href="fboard.do">게쉬판</a></label>
				</div>
			</nav>

<body>
	<br/>
	<br/>
	<a href="member.do?m=login_form" >로그인</a>(MVC)
	<br/>
	<a href="member.do?m=mAdd_form">회원가입</a>(MVC)
	<br/>
	<a href="member.do?m=m">회원수정</a>(MVC)
	<br/>
	<a href="member.do?m=mDel">회원탈퇴</a>(MVC)
	<br/>
	<a href="fboard.do" >파일업로드</a>(MVC)
	</center>

</body>
</html>