<%--
  Created by IntelliJ IDEA.
  User: JaneH
  Date: 2018/8/1
  Time: 2:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session</title>
</head>
<body>
<%
    if (request.getParameter("action").equals("login")) {
        session.setAttribute("uid", request.getParameter("uid"));
        session.setAttribute("username", request.getParameter("username"));
    } else if (request.getParameter("action").equals("logout")) {
        session.removeAttribute("uid");
        session.removeAttribute("username");
    }
%>
</body>
</html>
