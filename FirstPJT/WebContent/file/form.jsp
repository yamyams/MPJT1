<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>First Project Index</title>
</head>
<body>
	<center>
	<h2>FILE UPLOAD</h2>
	<form name="f" method="psot" action="../file.do?m=insert" enctype="multipart/form-data">
	</form>	<br/>
	유저 : <input type="text" name="writer" >
	<br/>
	파일 : <input type="file" name="fname">
		<input type="submit" value="전송">
	</center>

</body>
</html>