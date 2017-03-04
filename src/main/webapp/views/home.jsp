<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Restaurants</title>

    <!-- Bootstrap -->
    <link href="../resources/style/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="../resources/style/css/main3.0.css" rel="stylesheet">
    <link href="../resources/style/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" >
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<header id="header">
    <div class="header-top navbar-fixed-top">
        <div class="container">
            <div class="row">
                <div class="h-panel clearfix">
                    <span><p class="nav-emblem">Restaurants.ru</p></span>
                    <nav class="h-nav h-auth pull-right">
                        <a href="${pageContext.request.contextPath}/login">
                            <span><i class="fa fa-sign-in" aria-hidden="true"></i></span>Вход</a>
                        <a href="${pageContext.request.contextPath}/registration">
                            <span><i class="fa fa-user-plus" aria-hidden="true"></i></span>Регистрация</a>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <div class="header-bottom">
        <div class="container">
            <div class="row">
                <div class="h-bottom clearfix">
                    <div class="col-md-8 col-sm-9  h-menu" >
                        <ul class="nav nav-pills">
                            <li class="active">
                                <a href="${pageContext.request.contextPath}/home">Главная</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/restaurants">Рестораны</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/rating">Рейтинг</a>
                            </li>
                        </ul>
                    </div>
                    <div class="col-md-4 col-sm-5">
                        <form action="#" class="h-search">
                            <input type="text" placeholder="Поиск ресторана"/>
                            <button type="submit" value="">
                                <i class="fa fa-search" aria-hidden="true"></i>
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
<div class="container">
    <div class="row">
        <div class=".col-md-4 .col-md-offset-4">
            <img src="<c:url value="/upload_screen/test.jpg"/>" alt="" width="450px" height="250px">
        </div>
    </div>
</div>
<div class="footer">
    <div class="footer-bottom">
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-6 soc-button-bottom">
                    <nav class="h-nav h-icon pull-right">
                        <a href="#"><span><i class="fa fa-vk" aria-hidden="true"></i></span></a>
                        <a href="#"><span><i class="fa fa-facebook-official" aria-hidden="true"></i></span></a>
                        <a href="#"><span><i class="fa fa-twitter-square" aria-hidden="true"></i></span></a>
                        <a href="#"><span><i class="fa fa-youtube" aria-hidden="true"></i></span></a>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js" type="text/javascript"></script>
<script src="../resources/javascript/js/bootstrap.min.js" type="text/javascript" ></script>
</body>
</html>