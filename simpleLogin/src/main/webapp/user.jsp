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
	<p>User page</p>
	<header>
    	<h1>Онлайн библиотека</h1>
    	<h3>Вы можете посмотреть книги которые сейчас есть в наличии</h3>
    	<form action="SimpleServlet" method="get">
	    		<input type = "hidden" name="action"  value = "output">	    	    	    	   
	     	    <input type="submit" value="посмотреть">
	   		 </form>
    	<div class="subscribeUs">
	    	<form action="SimpleServlet" method="get">
	    		<input type = "hidden" name="action"  value = "search">
	    	    <input type="text" name="search" placeholder="Введите название книги" required>	    	   
	     	    <input type="submit" value="поиск">
	   		 </form>       
    	</div>
        <p>*You can not use without registering.</p>
		
</header>
     	<c:forEach var="val" items="${listbook}">
			<div class="book">
					<div class="insideImg"><img class="img" src=<c:out value="${val.getBookImage()}"/> height="100" width="100"></div>
					<div class="insideText">
						<a class="link" href="#">
							<i>${val.getTittle()}</i> 
							<i>${val.getAuthorName()}</i>
						</a>
					</div>							
				<form action="SimpleServlet" method="post">
					<input type="hidden" name="action" value="toTake">
					<input type="hidden" name="idForTakeProcessor" value="${val.getId()}">
					<input type="hidden" name="tittleForTakeProcessor" value="${val.getTittle()}">
					<input type="hidden" name="authorNameForTakeProcessor" value="${val.getAuthorName()}">
					<input type="hidden" name="bookImageForTakeProcessor" value="${val.getBookImage()}">					
					<input type="submit" value="добавить">													
				</form>
				<form action="SimpleServlet" method="get">
					<input type="hidden" name="action" value="viewBook">						
					<input type="submit" value="просмотр">													
				</form>							
			</div>
		</c:forEach>
			    	      
    	   
</body>
</html>