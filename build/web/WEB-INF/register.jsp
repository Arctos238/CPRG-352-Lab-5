<%-- 
    Document   : register.jsp
    Created on : 11-Oct-2022, 6:41:45 PM
    Author     : J. Pointer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="shoppingList" method="POST">
            <input type="hidden" name="action" value="register">
            <label>Username:</label>
            <input name="username" id="username"/>
            <input type="submit"  name="buttonRegister" id="buttonRegister" value="Register name">
        </form>
    </body>
</html>
