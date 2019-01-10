<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" /><title>edit page</title>
</head>
<body>
	<header>
    	<h1>Edit book</h1>
    	<h3>login to get the necessary access rights</h3>
    	<div class="edit">
	    	<form action="SimpleServlet" method="post">
	    	<div class="bookStyle">
	    		<c:out value="${user_name}"/>	    			
	    		<input type = "hidden" name="action"  value = "edit">
	    	    <input type="text" name="editBookName"  value="<c:out value="${book_value}"/>" >
	    	    <input type="text" name="editAuthorName"  value="<c:out value="${author_value}"/>" >	    	   
	    	    <input type="date" name="editDate"  value="<c:out value="${date_value}"/>" >
	    	    <input type ="hidden" name="editBookId"  value="<c:out value="${edit_book_id}"/>" >	    	   
	    	    <input type="submit" value="edit_submit">
	    	    
	    	 </div>   
	   		 </form>
       
    </div>
        <p>*You cann't use without registering.</p>

</header>
    
<section>
    <article>
       
    </article>
</section>
</body>
</html>