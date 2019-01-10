<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Page</title>

<style type="text/css">
   h3 { 
    
    color: red;
   }
  </style>

</head>
<body>
	<h3>Error Page:(</h3>

	 
	<div class="book">
       <p>article</p>
	    	<form action="SimpleServlet" method="post">
	    		<p><c:out value="${user_name}"/></p>	
	
			<h3><c:out value="${errStr}"/></h3> 
		</form>       
    	</div>
</body>
</html>