<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>MOOC</title>
    <%--<link type="text/css" rel="stylesheet" href="./css/general.css">--%>
    <link type="text/css" rel="stylesheet" href="./css/bootstrap-theme.css">
    <link type="text/css" rel="stylesheet" href="./css/bootstrap.min.css">
    <script type="application/javascript" rel="script" src="./js/jquery-3.3.1.min.js"></script>
    <script type="application/javascript" src="./js/bootstrap.min.js"></script>
    <%--<script type="application/javascript" src="./js/general.js"></script>--%>
</head>
<body>

<div class="header">
    <!--LOGO-->
    <h1>MOOC</h1>
    <!--右侧导航栏-->
    <div class="nav_right">
        <a href="index.jsp">首页</a>
        <a href="">搜索</a>
        <a href="">登录</a>
        <a href="">注册</a>
        <a href="">登出</a>
    </div>
</div>
<div id="homeBody">
    <!--轮播图片,最热的课程-->
    <div class="carousel_hot">
        <div class="carousel slide">
            <!-- 轮播（Carousel）指标 -->
            <ol class="carousel-indicators">
                <li data-target="#views" data-slide-to="0" class="active"></li>
                <li data-target="#views" data-slide-to="1"></li>
                <li data-target="#views" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="item active">
                    <a href=""><img src="" alt=""></a>
                    <div>
                        <p><!--课程描述--></p>
                    </div>
                </div>
                <div class="item">
                    <a href=""><img src="" alt=""></a>
                    <div>
                        <p><!--课程描述--></p>
                    </div>
                </div>
                <div class="item">
                    <a href=""><img src="" alt=""></a>
                    <div>
                        <p><!--课程描述--></p>
                    </div>
                </div>
            </div>
            <!-- 轮播（Carousel）导航 -->
            <a class="left carousel-control" href="#views" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#views" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>

    <!--最新的课程-->
    <div class="">
        <div class="col-md-4">
            <img src="" alt="">
            <h4>课程名称</h4>
            <p>课程描述</p>
            <a href="">View More</a>
        </div>
    </div>
</div>
</body>
</html>
