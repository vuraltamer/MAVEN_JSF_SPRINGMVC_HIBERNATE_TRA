<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<h1>
	Hello User  
</h1>
	<form action="/project/testLoginForm" method="post">
	<p><input type="text" name="email" >
	<input type="password" name="password" > </p>
	<p> </p>
	<p><input type="submit" value="Register" ></p>
	</form>

</body>
</html>