<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style0.css" />
<title>first page</title>
</head>
<body>	
	<header>
		<c:out value="${param}"/> 	
    	<h1>Welcome to our library</h1>
    	<h3>login to get the necessary access rights</h3>
    	<div class="subscribe">
	   		 
	    		<c:out value="${param}"/>	   		 
    	</div>
        <p>*You can not use without registering.</p>
			<c:forEach var="val" items="${listbook}">
				<div class="bookStyle">
					<div class="person">
						<div class="insideImg"><img class="img" src="img/1.jpg" height="100" width="100"></div>
						<div class="insideText"><a class="link" href="#"><span>${val.getTittle()} </span>${val.getAuthorName()}</a></div>
					</div>
				</div>
			</c:forEach>
			
   <article class="qqq">
	<h2>Lorem ipsum dolor</h2>
	<p class="event">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do 
	eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis 
	nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure 
	dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur 
	sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>

	</article>

</header>
    
<section>
    <article>
       
    </article>
</section>
</body>
</html>