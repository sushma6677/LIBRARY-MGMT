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
}

.links {
	background-color: green;
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
	background-color: gray;
}

a:hover {
	color: black;
}

a {
	color: white;
	text-decoration: none;
}
</style>

</head>

 <body bgcolor="black">


	<!--For Menu Option to the Admin  -->
	<div style="background-color: black;">
		
		</div>
		<div class="links">
			<a href="./bookscontroller/showsbooks" target="body">Book List</a>
		</div>
</body>
</html>