<%--
  Created by IntelliJ IDEA.
  User: captainlinux
  Date: 28/5/20
  Time: 2:50 π.μ.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="UTF-8">
<title>Contact</title>
<link rel="icon" type="image/svg" href="img/favicon.svg">
<link rel="stylesheet" type="text/css" href="../css/main.css"/>
<script src = "../js/main.js"></script>
</head>
<body>
<header>
    <div class = "navigation_bar">
        <a class = "selection" href = "../index.jsp"><img src = "../resources/images/favicon.svg" alt="Film Busters Logo"></a>
        <a class = "selection" href = "account.jsp">My Bookmarks</a>
        <a class = "selection" id = "current_page" href = "contact.jsp">Contact</a>
        <div class = "login_container">
            <a href = "#" id = "login_button"><span>Login</span><em></em></a>
            <div style = "clear:both"></div>
            <div id = "login_dropdown_box">
                <form id = "login_form">
                    <fieldset id = "body">
                        <fieldset>
                            <label for = "email"> Email Address </label>
                            <input type = "text" name = "email" id = "email" />
                        </fieldset>
                        <fieldset>
                            <label for = "password">Password</label>
                            <input type = "password" name = "password" id = "password" />
                        </fieldset>
                        <div id = "submit_buttons">
                            <input type = "submit" id = "login" value = "Log In" />
                            <input type = "submit" id = "signup" value = "Sign Up" />
                        </div>
                        <a href = "#"> Forgot your password?</a>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
    </div>
</header>
<div class = "grid_container">
    <div id = "introductory">
        <section>
            <h1> The Creators of FilmBusters </h1>
            <h3> </h3>
        </section>
    </div>
    <div id = "footer_info">
        <footer>
            <p><em>The page has been developed for the Web Development course! </em></p>
        </footer>
    </div>
</div>
</body>
</html>
