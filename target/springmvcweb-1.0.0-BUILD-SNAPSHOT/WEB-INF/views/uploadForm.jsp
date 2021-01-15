<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@include file="header.jsp" %>
	<hr>
	
	<form action="upload" method="post" enctype="multipart/form-data">
		
		select file <input type="file" name="file">
					<input type="submit" name="Upload">
	
	</form>
	
	<p>${msg}</p>
</body>
</html>