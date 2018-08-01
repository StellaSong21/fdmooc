<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>MOOC</title>

    <script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="css/index.css">
    <script src="js/index.js"></script>
</head>
<body>
<%
    out.print(session.getAttribute("username"));
%>
<div id="top-hot">
    <h3>热门课程</h3>
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">

        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox"></div>

        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>
<div id="latest-course" >
    <h3>最近发布</h3>
    <div class="row" id="latest-course-list">
    <%--<div id="latest1" class="col-lg-3">--%>
        <%--<img src="http://pic15.nipic.com/20110803/4402430_123201163000_2.jpg">--%>
        <%--<h6>course 1</h6>--%>
        <%--<p>aaebpiv v fvlnea fs eivgnljlf sb nfvsheb ioia;eavn o sjfc</p>--%>
    <%--</div>--%>
    <%--<div id="latest2" class="col-lg-3">--%>
        <%--<img src="">--%>
        <%--<h5>course 2</h5>--%>
        <%--<p>aaebpiv v fvlnea fs eivgnljlf sb nfvsheb ioia;eavn o sjfc</p>--%>
    <%--</div>--%>
    <%--<div id="latest3" class="col-lg-3">--%>
        <%--<img src="">--%>
        <%--<h5>course 3</h5>--%>
        <%--<p>aaebpiv v fvlnea fs eivgnljlf sb nfvsheb ioia;eavn o sjfc</p>--%>
    <%--</div>--%>
    </div>
</div>
</body>
</html>
