<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    	<div class="subscribe" class="indexSub">
	   		 <form action="SimpleServlet" method="get">
	    		<input type = "hidden" name="action"  value = "toSignIn">
	     	    <input type="submit" value="signe in">
	   		 </form>
	   		 <form action="SimpleServlet" method="get">
	     	    <input type = "hidden" name="action"  value = "toRegistration">
	     	    <input type="submit" value="sign up">
	   		 </form>
    	</div>

			
   <article class="qqq">
	<h2>Lorem ipsum dolor</h2>
	<p class="event">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do 
	eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis 
	nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure 
	dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur 
	sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
<p class="event">Имя Иисуса Христа несет в себе глубочайший смысл, являясь своеобразным кратким символом христианской веры.
 Иисус – греческая форма еврейского слова «Иешуа», что значит помощь Бога, или Спаситель. 
 Христос – греческое слово, означающее «Помазанник», на еврейском звучащее как Машиах – Мессия.</p>

	</article>

</header>
    
<section>
    <article>
       
    </article>
</section>
</body>
</html>