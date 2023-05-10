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
	height: 500px;
	width: 500px;
	background-color: gray;
	opacity: 0.7;
	margin-left: 300px;
	text-align: center;
}

input {
	border-radius: 10px;
}
</style>
</head>
<body>
<div class="libreg">
		<h1>Edit Books</h1>
		<br />
		<br />
		<c:choose>
			<c:when test="${searchBook ne null}">
				<form method="post" action="./bookscontroller/updatebook">
					<table cellpadding="10px" align="center">
						<c:forEach var="list" items="${searchBook }">
							<tr>
								<th>Book Id</th>
								<td><input type="text" name="bid" value="${list.bookId }" /></td>
							</tr>
							<tr>
								<th>Author Name</th>
								<td><input type="text" name="authorName" value="${list.authorName }" /></td>
							</tr>
							<tr>
								<th>Title</th>
								<td><input type="text" name="title"
									value="${list.title}" /></td>
							</tr>
							<tr>
								<th>category</th>
								<td><input type="text" name="catName"
									value="${list.catName}" /></td>
							</tr>

							<tr>
								<th>Book Price</th>
								<td><input type="text" name="bookPrice" value="${list.bookPrice }" /></td>
							</tr>

							<tr>
								<th>Quantity</th>
								<td><input type="text" name="qty"
									value="${list.qty}" /></td>
							</tr>

							<tr>
								<th>Edition</th>
								<td><input type="text" name="edition"
									value="${list.edition}" /></td>
							</tr>
                            <tr>
								<th>Description</th>
								<td><input type="text" name="description"
									value="${list.description}" /></td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input type="submit"
									value="Update" /></td>
							</c:forEach>
					</table>
				</form>
			</c:when>
			<c:otherwise>
			
		<h1 style="color: red; text-align: center">Book Record Not
					Found</h1>
				<div class="links">
					<a href="../updatebook.jsp">Update Books </a>
				</div>
			</c:otherwise>
			</c:choose>
	</div>
			
</body>
</html>