<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style1.css" />
<title>edit page</title>
</head>
<body>
	<header>
    	<h1>Open book</h1>
    	<h3>login to get the necessary access rights</h3>
    	<div class="edit">
	    	<form action="SimpleServlet" method="post">
	    	<div class="bookStyle">
	    
	    		<c:out value="${book_name}"/>
	    		<c:forEach var="val" items="${comments}">
			    	 
				    	<p>${val}</p>				    		 
				    					    			    		
			    </c:forEach> 
	    		<input type = "hidden" name="action"  value = "openBook">
	    	    
	    	    
	    	 </div>   
	   		 </form>
       
    </div>
        <p>*You can not use without registering.</p>

</header>
    
<section>
    <article>
       
    </article>
</section>
</body>
</html>