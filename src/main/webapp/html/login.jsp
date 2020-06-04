<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>FilmBusters - Login</title>
	<link rel="icon" href="${pageContext.request.contextPath}/resources/static/images/favicon.svg" type="image/x-icon">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/static/css/index_login_styling.css"/>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
	<script> 
	function validate()
	{ 
		let username = document.form.username.value;
		let password = document.form.password.value;
 
		if (username===null || username==="") {
			alert("Username cannot be blank"); 
			return false; 
		}
		else if(password===null || password==="") {
			alert("Password cannot be blank"); 
			return false; 
		} 
	}
	</script> 
</head>
<body>
	<header>
		<div class = "navigation_bar">
			<a class = "selection" id = "nav_logo" href = "${pageContext.request.contextPath}/index"><img src = "${pageContext.request.contextPath}/resources/static/images/favicon.svg" alt = "logo"></a>
			<a class = "selection" href = "${pageContext.request.contextPath}/account">My Bookmarks</a>
			<a class = "selection" href = "${pageContext.request.contextPath}/contact">Contact</a>
		</div>
	</header>
	<div id = "login_container">
		<div id = "introductory">
			<section>
				<h1> Login </h1>
				<h3> <i>FilmBusters</i> is a website where you can search a movie and get some information regarding it, as well as save them as bookmarks for future movie-nights! </h3>
				<h3> You must <i style = "color: red;">log-in</i> with your existing account to proceed, else you have to create a new account!</h3>
			</section>
		</div>
		<div id = "login_form">
			<fieldset>
				<legend> LOGIN </legend>
				<form action = "/action_page.php" method = "get">
					<%--@declare id="e-mail"--%><%--@declare id="password"--%><label for = "e-mail"> E-mail: </label>
					<input type = "email" placeholder = "someone@example.com" name = "last_name"><br>
					<label for = "password"> Password: </label>
					<input type = "password" name = "password"><br>
					<div id = "submit_buttons">
						<input type = "submit" id = "login" value = "Log In" />
						<input type = "submit" id = "signup" value = "Sign Up" />
					</div>
				</form>
			</fieldset>
		</div>
		<div id = "footer_info">
			<footer>
				<p><em>The page has been developed for the Web Development course! </em></p>
			</footer>
		</div>
	</div>
</body>
</html>