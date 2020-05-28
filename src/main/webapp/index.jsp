<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: captainlinux
  Date: 28/5/20
  Time: 2:24 π.μ.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>FilmBusters Home Page</title>
    <link rel="icon" href='<c:url value="/resources/images/favicon.ico" />' type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="css/index_styling.css"/>
    <link rel="stylesheet" type="text/css" href="css/login_styling.css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
    <script src = "js/main.js"></script>
</head>
<body>
<header>
    <div class = "navigation_bar">
        <a class = "selection" id = "current_page" href = "index.jsp"><img src = "resources/images/favicon.svg" alt="Film Busters Logo"></a>
        <a class = "selection" href = "html/account.jsp">My Bookmarks</a>
        <a class = "selection" href = "html/contact.jsp">Contact</a>
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
            <h1> Welcome to FilmBusters! </h1>
            <h3> This is a page where you can find important details about a film you are searching as well as see the ratings from popular rating sites! Type the name of the film in the search bar to begin...</h3>
        </section>
    </div>
    <div id = "search_bar">
        <section>
            <ul>
                <li id = "movie_title_header"> Name of the movie: </li>
            </ul>
            <input type="text" name = "search" placeholder = "Search...">
        </section>
    </div>
    <div id = "search_results">
        <section id = "basic_movie_info">
            <h4> MOVIE NAME </h4>
            <span> (YEAR) / (GENRE) </span>
        </section>
        <section id = "movie_image">
            <picture>
                <!--<source media = "(max-width: 883px)" srcset = "mobile_images/tim_berners_lee_mobile.jpg">-->
                <img id = "no_image" src = "resources/images/no_image.jpg" alt = "no_image_placeholder">
            </picture>
        </section>
        <section id = "movie_description">
            <p> NO DESCRIPTION AVAILABLE </p>
            <section id = "ratings">
                <h5> RATINGS: </h5>
                <div id = "ratings_alignment">
                    <div style = "text-align: left">
                        <img style = "vertical-align: middle" src = "resources/images/imdb.png" alt = "imdb"> : <span id = "imdb_rating">0</span> / 10
                    </div>
                    <div style = "text-align: left">
                        <img style = "vertical-align: middle" src = "resources/images/rotten_tomatoes.png" alt = "rt"> : <span id = "rt_rating">0</span> %
                    </div>
                    <div style = "text-align: left">
                        <img style = "vertical-align: middle" src = "resources/images/metacritic.png" alt = "mt"> : <span id = "mc_rating">0</span>
                    </div>
                </div>
            </section>
        </section>
        <section id = "more_info">
            <button id = "more_info_button"><span> More </span></button>
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
