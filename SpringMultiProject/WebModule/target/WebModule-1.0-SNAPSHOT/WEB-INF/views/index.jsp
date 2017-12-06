<%-- 
    Document   : index
    Created on : 11-Nov-2017, 23:53:09
    Author     : kamal
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Products!</h1>
    <li>
        <c:forEach var="p" items="${products}">
        <li>${p.name} (Brand:${p.brand.name}) (Category:${p.category.name})</li>
        </c:forEach>
</li>
</body>
</html>
