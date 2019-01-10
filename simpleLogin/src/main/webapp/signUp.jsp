<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>first page</title>
</head>
<body>
	<header>
    	<h1>Welcome to our library</h1>
    	<h3>login to get the necessary access rights</h3>
    	<div class="subscribe">
	    	<form action="SimpleServlet" method="post" enctype="multipart/form-data">
	    		<input type = "hidden" name="action"  value = "doRegistration">
	    	    <input type="text" name="nameUser" placeholder="enter your name" required><br>
   	    	    <input type="text" name="surnameUser" placeholder="enter your surname" required><br>
   	    	    <input type="text" name="newLogin" placeholder="enter your login" required><br>
	    	    <input type="password" name="newPassword" placeholder="enter password" required><br>
	    	    <input type="file" name="file"><br>
	    	    
	     	    <input type="submit" value="check in">
	   		 </form>      
    	</div>
        <p>*You can not use without registering.</p>
        	<article class="qqq">
				
			</article>
	</header>
    
<section>
    <article>
       
    </article>
</section>
</body>
</html>