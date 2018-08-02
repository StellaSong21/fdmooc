<%--
  Created by IntelliJ IDEA.
  User: JaneH
  Date: 2018/8/2
  Time: 1:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>search in MOOC</title>
    <script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="css/discuss.css">

</head>
<body>
<%@ include file="nav.jsp" %>
<div id="container">
    <nav aria-label="...">
        <ul class="pagination">
            <li class="disabled">
      <span>
        <span aria-hidden="true">&laquo;</span>
      </span>
            </li>
            <li class="active">
                <span>1 <span class="sr-only">(current)</span></span>
            </li>
            ...
        </ul>
    </nav>
</div>
<script src="js/search.js"></script>
</body>
</html>
