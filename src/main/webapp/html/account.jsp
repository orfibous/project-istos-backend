<%--
  Created by IntelliJ IDEA.
  User: captainlinux
  Date: 28/5/20
  Time: 2:50 π.μ.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>FilmBusters - My Bookmarks</title>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/static/images/favicon.svg" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/static/css/bookmarks_styling.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/static/css/login_styling.css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
    <script type="text/javascript" src = "${pageContext.request.contextPath}/resources/static/js/bookmark_handler.js"></script>
    <script type="text/javascript" src = "${pageContext.request.contextPath}/resources/static/js/login_handler.js"></script>
</head>
<body>
    <header>
        <div class = "navigation_bar">
            <a class = "selection" id = "nav_logo" href = "${pageContext.request.contextPath}/index"><img src = "${pageContext.request.contextPath}/resources/static/images/favicon.svg" alt = "logo"></a>
            <a class = "selection" href = "${pageContext.request.contextPath}/account">My Bookmarks</a>
            <a class = "selection" href = "${pageContext.request.contextPath}/contact">Contact</a>
            <div class = "login_container">
                <button class = "login_button">Login</button>
                <div class = "login_dropdown_box">
                    <form id = "login_form">
                        <fieldset id = "body">
                            <fieldset>
                                <label for = "email"> &#9654; Email Address </label>
                                <input type = "text" name = "email" id = "email" />
                            </fieldset>
                            <fieldset>
                                <label for = "password"> &#9654; Password</label>
                                <input type = "password" name = "password" id = "password" />
                            </fieldset>
                            <div id = "submit_buttons">
                                <input type = "submit" id = "login" value = "Log In" />
                                <input type = "submit" id = "signup" value = "Sign Up" />
                            </div>
                            <a href = "#" id = "forgot_password"> Forgot your password?</a>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </header>
    <div class = "grid_container">
        <div id = "introductory">
            <section>
                <h1> My Bookmarks </h1>
                <h3> Here you can access the bookmarks you have saved from the your searches. <br> You can also delete the bookmarks you don't want anymore! </h3>
            </section>
        </div>
        <h3 id = "no_bookmarks"> Your bookmarks' list is empty! </h3>
        <div id = "bookmarks_box">
            <div class = "single_bookmark_box">
                <section class = "bookmark_title">
                    <h4><span>&#9654; </span> Bookmark <span class = "bookmark_counter"> 1 </span></h4>
                </section>
                <section class = "remove_bookmark_box">
                    <img src = "${pageContext.request.contextPath}/resources/static/images/remove_bookmark.png" alt = "remove_bookmark" class = "remove_bookmark"/>

                </section>
                <section class = "movie_image">
                    <img class = "image_placeholder" src = "${pageContext.request.contextPath}/resources/static/images/no_image.jpg" alt = "no_image_placeholder">
                </section>
                <section class = "bookmark_info">
                    <p class = "movie_name_label"> MOVIE_NAME </p>
                    <span class = "year"> (YEAR) </span><span> / </span><span class = "genre"> (GENRE) </span>
                    <ul>
                        <li><b style = "font-size: 18px;"><u>Directed by</u></b><i class = "director_name"> NO DIRECTOR NAME AVAILABLE </i></li>
                        <li><b style = "font-size: 18px;"><u>Starring</u>:</b> <i class = "actor_names"> NO ACTOR NAMES AVAILABLE </i></li>
                        <li><b style = "font-size: 18px;"><u>Summary</u>:</b><i class = "description"> NO SUMMARY AVAILABLE </i></li>
                    </ul>
                </section>
            </div>
            <div class = "single_bookmark_box">
                <section class = "bookmark_title">
                    <h4><span>&#9654; </span> Bookmark <span class = "bookmark_counter"> 1 </span></h4>
                </section>
                <section class = "remove_bookmark_box">
                    <img src = "${pageContext.request.contextPath}/resources/static/images/remove_bookmark.png" alt = "remove_bookmark" class = "remove_bookmark"/>

                </section>
                <section class = "movie_image">
                    <img class = "image_placeholder" src = "${pageContext.request.contextPath}/resources/static/images/no_image.jpg" alt = "no_image_placeholder">
                </section>
                <section class = "bookmark_info">
                    <p class = "movie_name_label"> MOVIE_NAME </p>
                    <span class = "year"> (YEAR) </span><span> / </span><span class = "genre"> (GENRE) </span>
                    <ul>
                        <li><b style = "font-size: 18px;"><u>Directed by</u></b><i class = "director_name"> NO DIRECTOR NAME AVAILABLE </i></li>
                        <li><b style = "font-size: 18px;"><u>Starring</u>:</b> <i class = "actor_names"> NO ACTOR NAMES AVAILABLE </i></li>
                        <li><b style = "font-size: 18px;"><u>Summary</u>:</b><i class = "description"> NO SUMMARY AVAILABLE </i></li>
                    </ul>
                </section>
            </div>
        </div>
        <div id = "footer_info">
            <footer>
                <p><em>The page has been developed for the Web Development course! </em></p>
            </footer>
        </div>
    </div>
</body>
</html>
