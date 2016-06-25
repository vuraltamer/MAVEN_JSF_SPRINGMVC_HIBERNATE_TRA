<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello User  
</h1>
	<form action="/conf/submitUserBox" method="post">
	<input type="text" name="name" >
	<input type="submit" value="Register" >
	</form>

</body>
</html>
