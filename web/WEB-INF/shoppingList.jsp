<%-- 
    Document   : shoppingList
    Created on : 11-Oct-2022, 6:42:01 PM
    Author     : Arcto
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, <c:out value="${username}"/> <a href="shoppingList?action=logout">Logout</a></p>
        <h2>List</h2>

        <form action="shoppingList" method="post">
            <input type="hidden" name="action" value="add">
            <label>Item:<input type="text" name="item"></label>
            <button type="submit">Submit</button>
        </form>
        <br>
        <form action="shoppingList" method="post">
            <input type="hidden" name="action" value="delete">
            <c:forEach var="item" items="${items}">
                <label><input type="radio" name="item" value="<c:out value="${item}"/>"> <c:out value="${item}"/></label>
                <br>
            </c:forEach>
            <br>
            <button type="submit">Delete</button>   
        </form>
    </body>
</html>
