<%-- 
    Document   : shoppingList
    Created on : 11-Oct-2022, 6:42:01 PM
    Author     : Arcto
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username} <a href="shoppingList?action=logout" action=logout"">Logout</a></p>
        <h2>List</h2>
        <form>
            <label>Add item:</label>
            <input type="text" name="listItem" id="listItem">
            <button type="submit">Add</button>
        </form>
    </body>
</html>
