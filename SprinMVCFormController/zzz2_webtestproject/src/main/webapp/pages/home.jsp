<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>
		<f:form action="homeOut" method="post" commandName="userForm">
			<tr>
				<td>Ad: <f:input path="username" /></td>
			</tr>
			<tr>
				<td>Parola: <f:password path="password"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Register" /></td>
			</tr>
		</f:form>
		
	</h1>
</body>
</html>
