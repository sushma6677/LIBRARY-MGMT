<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	margin: 0px;
	font-family: "Audiowide", sans-serif;
	color: white;
	background-image: url('background-modified.jpg');
	background-repeat: no-repeat;
	height: 500px;
	width: 700px;
	background-size: 1525px 650px;
	
}

header {
	margin: 0px;
	padding: 5px;
}

.links {
	background-color: black;
	height: 30px;
	text-align: center;
	padding: 10px;
	border: 2px solid gray;
	border-radius: 12px;
	padding: 5px;
	margin: 10px;
	padding: 5px;
}

.links:hover {
	background-color: blue;
	border: 2px solid black;
}

a:hover {
	color: black;
}

a {
	color: white;
	text-decoration: none;
}

.libreg {
	color: blue;
	height: 500px;
	width: 500px;
	background-color: gray;
	opacity: 0.7;
	margin-left: 300px;
	text-align: center;
	
}
tr{
padding: 20px;
}

input {
	border-radius: 10px;
}
</style>
</head>
<body>
<div class="libreg">
<h1>Result Page</h1>
		<br /> <br />
<c:choose>
<c:when test="${updateBook eq 'success'}">
<h1 style="color: green; text-align: center">Book Record Updated
					Successfully</h1>

<div class="links">
					<a href="../../updatebook.jsp">Update More Books</a>
				</div>
</c:when>


<c:otherwise>
<h1 style="color: red; text-align: center">Book Record  not Updated
					</h1>
<div class="links">
<a href="../../updatebook.jsp">Update More Books</a>
				</div>

</c:otherwise></c:choose>
</div>
</body>
</html>