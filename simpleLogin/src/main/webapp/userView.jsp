<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Insert title here</title>
</head>
<body>
	<p>User view</p>			
	<div class="person">
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
		<div class="personView">
			<p class="block">
				<img class="img" src=<c:out value="${sessionScope.user_image}"/> height="150" width="150">
				<c:out value="${sessionScope.user_name}"/> 
				<c:out value="${sessionScope.user_surname}"/>		
			</p>								
		</div>
	</header>
	<pre>
	
	</pre>
	<p style="color: white">Книга</p>
				<c:out value="${sessionScope.bookTitle}"/>		
				<c:out value="${sessionScope.bookAuthor}"/>		
			<img class="img" src=<c:out value="${sessionScope.bookImg}"/> height="150" width="150">
				
				<form action="SimpleServlet" method="post">
					<input type="hidden" name="action" value="render">
					<input type="submit" value="вернуть">													
				</form>							
		
    	
			    	      
    	   
</body>
</html>