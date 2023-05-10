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
	background-image: url('../background-modified.jpg');
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
	width: 400px;
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
	/* height: 500px; */
	width: 1270px;
	background-color: gray;
	opacity: 0.7;
	/* margin-left: 200px;  */
	text-align: center;
}

input {
	border-radius: 10px;
}

th {
	color: white;
}
</style>
</head>
<body>
<div class="libreg">
		<h1>All Books Record</h1>
		<br /> 
		<c:choose>
			<c:when test="${allBooks ne null}">
				<table border="1" cellpadding="5px" align="center">
					<tr style="background-color: black;">
						<th>Book Id</th>
						<th>Author Name</th>
						<th>Title</th>
						<th>Category</th>
						<th>Book Price</th>
						<th>Quantity</th>
						<th>Edition</th>
						<th>description</th>
					</tr>
					<c:forEach var="list" items="${allBooks}">
						<tr>
							<td>${list.bookId }</td>
							<td>${list.authorName}</td>
							<td>${list.title}</td>
							<td>${list.catName }</td>
							<td>${list.bookPrice}</td>
							<td>${list.qty}</td>
							<td>${list.edition }</td>
							<td>${list.description}</td>
						</tr>
					</c:forEach>
				</table><br />
			</c:when>
		</c:choose>

	</div>
</body>
</html>