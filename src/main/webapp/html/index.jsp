<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: captainlinux
  Date: 28/5/20
  Time: 2:24 π.μ.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>FilmBusters - Homepage</title>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/static/images/favicon.svg" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/static/css/index_styling.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/static/css/login_styling.css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
    <script type="text/javascript" src = "${pageContext.request.contextPath}/resources/static/js/index_handler.js"></script>
    <script type="text/javascript" src = "${pageContext.request.contextPath}/resources/static/js/login_handler.js"></script>
    <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"></script>
    <script type="text/javascript"
            src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>

</head>
<body>
<header>
    <div class = "navigation_bar">
        <a class = "selection" id = "nav_logo" href = "${pageContext.request.contextPath}/"><img src = "${pageContext.request.contextPath}/resources/static/images/favicon.svg" alt = "logo"></a>
        <a class = "selection" href = "${pageContext.request.contextPath}/account">My Bookmarks</a>
        <a class = "selection" href = "${pageContext.request.contextPath}/contact">Contact</a>
        <div class = "login_container">
           <a class = "logout_link" href = "LogoutServlet"> Logout </a>
        </div>
    </div>
</header>
<div class = "grid_container">
    <div id = "introductory">
        <section>
            <h1> Welcome to FilmBusters! </h1>
            <h3> This is a page where you can find important details about a film you are searching as well as see the ratings from popular rating sites! <br> You can vote for a selected movie as well as save it as a bookmark, which can be then accessed from the "My Bookmarks" tab! <br> Use the search bar below to start searching for a movie. </h3>
        </section>
    </div>
    <div id = "search_bar">
        <section>
            <ul>
                <li id = "movie_title_header"> Name of the movie: </li>
            </ul>
            <input type="text"  placeholder = "Search..." id = "searchBar">
        </section>
    </div>
    <div id = "search_results">
        <section id = "basic_movie_info">
            <h4 id = "movie_name"> MOVIE NAME </h4>
            <span id = "year"> (YEAR) </span><span> / </span><span id = "genre"> (GENRE) </span>
        </section>
        <section id = "voting_box"> <%--   TODO this must make and insert or drop query to the database based on the request data.imdbID     --%>
            <img src = '${pageContext.request.contextPath}/resources/static/images/save_bookmark.png' alt = "like" id = "vote_selection"/>
        </section>
        <section id = "movie_image">
            <picture>
                <img id = "no_image" src = "${pageContext.request.contextPath}/resources/static/images/no_image.jpg" alt = "no_image_placeholder">
            </picture>
        </section>
        <section id = "movie_description">
            <p id = "description" style = "color:red;"> NO DESCRIPTION AVAILABLE </p>
        <section id = "ratings">
            <h5> RATINGS: </h5>
            <div id = "ratings_alignment">
                <div style = "text-align: left">
                    <img style = "vertical-align: middle" src = "${pageContext.request.contextPath}/resources/static/images/imdb.png" alt = "imdb"> : <span id = "imdb_rating">0</span> / 10
                </div>
                <div style = "text-align: left">
                    <img style = "vertical-align: middle" src = "${pageContext.request.contextPath}/resources/static/images/rotten_tomatoes.png" alt = "rt"> : <span id = "rt_rating">0</span>
                </div>
                <div style = "text-align: left">
                    <img style = "vertical-align: middle" src = "${pageContext.request.contextPath}/resources/static/images/metacritic.png" alt = "mt"> : <span id = "mc_rating">0</span>
                </div>
            </div>
        </section>
        </section>
        <section id = "additional_information">
            <h5 style = "text-align: center;"> Additional Information for the movie </h5>
            <table>
                <tr>
                    <td> RELEASE DATE: </td>
                    <td id = "release_date"> DD / MM / YYYY </td>
                </tr>
                <tr>
                    <td> WRITER: </td>
                    <td id = "writer_names"> NO WRITER NAMES AVAILABLE </td>
                </tr>
                <tr>
                    <td> DIRECTOR: </td>
                    <td id = "director_names"> NO DIRECTOR NAMES AVAILABLE </td>
                </tr>
                <tr>
                    <td> ACTORS: </td>
                    <td id = "actor_names"> NO ACTOR NAMES AVAILABLE </td>
                </tr>
                <tr>
                    <td> RUNTIME: </td>
                    <td id = "runtime"> 0 min </td>
                </tr>
                <tr>
                    <td> RATED: </td>
                    <td id = "rated_value"> NOT RATED </td>
                </tr>
                <tr>
                    <td> LANGUAGE: </td>
                    <td id = "language"> UNDEFINED </td>
                </tr>
                <tr>
                    <td> COUNTRY: </td>
                    <td id = "country"> UNDEFINED </td>
                </tr>
            </table>
        </section>
        <section id = "more_info">
            <button id = "more_info_button"><span> More &#9660 </span></button>
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
