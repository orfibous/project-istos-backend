<%--
	Alexandros Giarengkin 3160025
	Orfeas Georgios Mposoulas - Raikidis 3160111
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>FilmBusters - Contact</title>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/static/images/favicon.svg" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/static/css/contact_styling.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/static/css/login_styling.css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
    <script type="text/javascript" src = "${pageContext.request.contextPath}/resources/static/js/login_handler.js"></script>
</head>
<body>
    <header>
        <div class = "navigation_bar">
            <a class = "selection" id = "nav_logo" href = "${pageContext.request.contextPath}/index"><img src = "${pageContext.request.contextPath}/resources/static/images/favicon.svg" alt = "logo"></a>
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
                <h1> The Creators of FilmBusters </h1>
                <h3> <em>FilmBusters</em> was created as a web development project, trying to simulate a movie database of some kind with a voting system and a bookmarking feature. <br>It is the work of two individuals and below you can see some information about us. </h3>
            </section>
        </div>
        <div id = "contact_box">
            <!--Individual 1-->
            <section class = "individual_name">
                <h4>ALEXANDER YARENGIN</h4>
            </section>
            <section class = "individual_image">
                <picture>
                    <img src = "${pageContext.request.contextPath}/resources/static/images/Alex.jpg" alt = "Alex">
                </picture>
            </section>
            <section class = "individual_description">
                <p> My name is Alexander Yarengin, I am 22 years old and I study Informatics at the Athens University of Economics and Business (AUEB). Here are a few things about me:</p>
                <ul class = "individual_info">
                    <li><b><u>Year</u></b>:<i> 4 </i></li>
                    <li><b><u>Fields to specialize</u></b>: <i>Web Development & Data Science (Data Analytics, Machine Learning etc.)</i></li>
                    <li><b><u>Interests</u></b>:<i> Gymnastics, Books, Video Games, Programming (experimenting) </i></li>
                    <li><b><u>Languages</u></b>:<i> Greek, Russian, English, German </i></li>
                </ul>
                <p>You can contact me via my facebook profile <a href="https://www.facebook.com/alex.yarengin">here</a> or by sending an email <a href="https://mail.google.com/mail/?view=cm&fs=1&tf=1&to=alexyarengin11@gmail.com" target="_blank"> here</a>.</p>
            </section>
            <!--Individual 2-->
            <section style = "margin-top: 20px;" class = "individual_name2">
                <h4>ORFEAS-GEORGIOS BOUSOULAS-RAIKIDIS </h4>
            </section>
            <section class = "individual_image2">
                <picture>
                    <img src = "${pageContext.request.contextPath}/resources/static/images/Orfi.jpg" alt = "Orfeas">
                </picture>
            </section>
            <section class = "individual_description2">
                <p> My name is Orfeas-Georgios Bousoulas-Raikidis, I am 22 years old and I study Informatics at the Athens University of Economics and Business (AUEB). Here are a few things about me:</p>
                <ul class = "individual_info">
                    <li><b><u>Year</u></b>:<i> 4 </i></li>
                    <li><b><u>Fields to specialize</u></b>: <i> Software Development, Web Development, Open Source </i></li>
                    <li><b><u>Interests</u></b>: <i> Photography, Cooking, Football </i></li>
                    <li><b><u>Languages</u></b>: <i> Greek, English </i></li>
                </ul>
                <p>You can contact me via my facebook profile <a href="https://www.facebook.com/profile.php?id=100008175489350">here</a> or by sending an email <a href="https://mail.google.com/mail/?view=cm&fs=1&tf=1&to=orfibus@gmail.com" target="_blank"> here</a>.</p>
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