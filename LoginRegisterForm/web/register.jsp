<%-- 
    Document   : register
    Created on : 23 Οκτ 2019, 1:41:33 πμ
    Author     : Kostas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="styles.css">
        <title>Create your account</title>
    </head>
    <body>
        <form class="register-form" action="loginRegister" method="POST">
            <div class="register-box">
                <h1>Create an account</h1>
                <h1 class="diffPass" style="font-size: 13px;">${diffPassword}</h1>
                <h1 class="inclUsr" style="font-size: 13px;">${includedMessage}</h1>
                <h1 class="misInfo" style="font-size: 13px;">${missingArgs}</h1>
                <img class="user-icon" src = "register-icon.png" alt="user" width="100" height="-60">
                <table class="register-table">
                    <tr><td><input class="table-cell" type="text" name="username" placeholder="Username"</td></tr>
                    <tr><td><input class="table-cell" type="text" name="first-name" placeholder="First name"</td></tr>
                    <tr><td><input class="table-cell" type="text" name="last-name" placeholder="Last name"</td></tr>
                    <tr><td><input class="table-cell" type="email" name="email" placeholder="E-mail"</td></tr>
                    <tr><td><input class="table-cell" type="password" name="password1" placeholder="Password"</td></tr>
                    <tr><td><input class="table-cell" type="password" name="password2" placeholder="Confirm password"</td></tr>
                    <tr><td><input class="table-cell submit"type="submit" name="submit" value="SIGN UP"</td></tr>
                </table>
            </div>
        </form>
    </body>
</html>
