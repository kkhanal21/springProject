<%-- 
    Document   : index
    Created on : 06-Nov-2017, 16:06:24
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
        <c:forEach var="category" items="${categories}">
            <h1>${category.name}</h1>
        </c:forEach>

    </body>
</html>
