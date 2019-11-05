<%-- 
    Document   : index
    Created on : 22 Οκτ 2019, 7:25:05 μμ
    Author     : Kostas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css">
        <title>Login to account</title>
    </head>
    <body>
        <h1 class="successMsg">${successMessage}</h1>
        <h1 class="successMsg">${successDel}</h1>
        <form class="login-form" action="loginRegister" method="POST">
            <div class="login-box">
                <h1>Login to account</h1>
                <h1 class="invalidPassword" style="font-size: 13px;">${invalidPassword}</h1>
                <h1 class = "wrongMessage" style="font-size: 13px;">${wrongMessage}</h1>
                <img class="user-icon" src = "user-icon.png" alt="user" width="100" height="100">
                <table class="login-table">
                    <tr><td><input class="table-cell" type="text" name="username" placeholder="Username"</td></tr>
                    <tr><td><input class="table-cell" type="password" name="password1" placeholder="Password"</td></tr>
                    <tr><td><input class="table-cell submit"type="submit" name="submit" value="LOG IN"</td></tr>
                    <tr><td class="register">Not registered? <a href="register.jsp">Create an account</a></td></tr>
                </table>
            </div>
        </form>
    </body>
</html>
