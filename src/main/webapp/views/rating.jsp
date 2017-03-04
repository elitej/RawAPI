<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Restaurants</title>

    <!-- Bootstrap -->
    <link href="../resources/style/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="../resources/style/css/main3.0.css" rel="stylesheet">
    <link href="../resources/style/css/restaurants.css" rel="stylesheet">
    <link href="../resources/style/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" >
    <link href="../resources/style/css/rating.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Space+Mono" rel="stylesheet">

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
                    <span  ><p class="nav-emblem">Restaurants.ru</p></span>
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
                            <li>
                                <a href="${pageContext.request.contextPath}/home">Главная</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/restaurants">Рестораны</a>
                            </li>
                            <li class="active">
                                <a href="${pageContext.request.contextPath}/rating">Рейтинг</a>
                            </li>
                        </ul>
                    </div>
                    <div class="col-md-4 col-sm-5 ">
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


<div class="content">
    <div class="container">
        <c:forEach items="${restaurantList}" var="restaurant" varStatus="loop">
            <div class="row">
                <div class="rating-content clearfix">
                    <div class="col-md-3 col-md-offset-2">
                        <div class="row rating" >
                            <span class="position pull-left">${loop.index + 1}</span>
                            <div class="ratio pull-right">
                                <span>4.4</span>
                                <div class="star-rating">
                                    <span><i class="fa fa-star" aria-hidden="true" title="4.4"></i></span>
                                    <span><i class="fa fa-star" aria-hidden="true" title="4.4"></i></span>
                                    <span><i class="fa fa-star" aria-hidden="true" title="4.4"></i></span>
                                    <span><i class="fa fa-star" aria-hidden="true" title="4.4"></i></span>
                                    <span><i class="fa fa-star-half-o" aria-hidden="true" title="4.4"></i></span>
                                </div>
                            </div>
                        </div>
                        <div class="title">
                            <a href="/restaurant-info/${restaurant.id}" class="name">
                                <div class="name">${restaurant.name}</div>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-5 image pull-left">
                        <a href="/restaurant-info/${restaurant.id}">
                            <img src="<c:url value = "/upload_screen/${restaurant.image}"/>"
                                 alt="" width="450px" height="250px">
                        </a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<div class="paging">
    <div class="container">
        <div class="row">
            <div class="text-center">
                <ul class="pagination pagination-lg">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li class="active"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </div>
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="../resources/javascript/js/bootstrap.min.js" type="text/javascript" ></script>
</body>
</html>
