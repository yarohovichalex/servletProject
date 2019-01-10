<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8"/>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Second Page</title>
</head>
<body>
	<p>Admin page</p>
	<div class="person">
		<p class="block">
			<a href="userView.jsp">
				<img class="img" src=<c:out value="${sessionScope.user_image}"/> height="55" width="55">
			</a>
			<c:out value="${sessionScope.user_name}"/> 
			<c:out value="${sessionScope.user_surname}"/>		
		</p>
		<form class="block" action="SimpleServlet" method="get" >
			<input type="hidden" name="action" value="exit">						
			<input type="submit" value="выход">													
		</form>
		<form class="block" action="SimpleServlet" method="get" >
			<input type="hidden" name="action" value="toIndex">						
			<input type="submit" value="главная">													
		</form>							
	</div>
	<header>
		<h1>First library</h1>
		<h3>search book</h3>
		
			<form action="SimpleServlet" method="get">
				<input type="hidden" name="action" value="output"> 
				<input type="submit" value="output ">
			</form>
			<form action="SimpleServlet" method="get">
				<input type="hidden" name="action" value="search"> 
				<input type="search" name="search" placeholder="search for name book" required> 
				<input type="submit" value="search ">
			</form>
		<div>
			<form action="SimpleServlet" method="post">
				<input type="hidden" name="action" value="add"> 
				<input type="text" name="addName" placeholder="add name book" required>
				<input type="text" name="addAuthor" placeholder="add name author" required>
				<input type="date" name="publishDate" required>				
				<input type="submit" value="add">
			</form>
		</div>
		<p>*You can not use without registering.</p>

	
				<c:out value="${user_name}"/>
				<c:forEach var="val" items="${listbook}">

						<div class="book">
							<form action="" method="get">
								<div class="insideImg"><img class="img" src=<c:out value="${val.getBookImage()}"/> height="100" width="100"></div>
								<div class="insideText"><a class="link" href="#"><span>${val.getTittle()} </span>${val.getAuthorName()}</a></div>			
							</form>
							<form action="SimpleServlet" method="post">
								<input type="hidden" name="action" value="delete"> 
								<input type="hidden" name="book_id" value="${val.getId()}"> 
								<input type="submit" value="delete">
							</form>
							<form action="SimpleServlet" method="get">
								<input type="hidden" name="action" value="ToEdit">						
								<input type="hidden" name="BookIdIntoEditPage" value="${val.getId()}">
								<input type="hidden" name="BookNameIntoEditPage" value="${val.getTittle()}">
								<input type="hidden" name="DateIntoEditPage" value="${val.getDate()}">
								<input type="hidden" name="AuthorNameIntoEditPage" value="${val.getAuthorName()}">
								<input type="submit" onclick="edit" value="ToEdit">													
							</form>
						</div>
				</c:forEach>
				<div id="render"></div>
			
			<p></p>
			<p></p>			
			<div class="coment">
				<form action="SimpleServlet" method="post" enctype="multipart/form-data">
					<input type = "hidden" name="action" value = "upload">				
					<input type="file" name="file"><br>
					<textarea name="description" cols="20" wrap="soft"></textarea>
					<input type="submit" value="upload">
				</form>
			</div>
		
	</header>		
</body>
</html>