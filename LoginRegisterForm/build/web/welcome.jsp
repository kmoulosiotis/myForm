<%-- 
    Document   : welcome
    Created on : 30 Οκτ 2019, 10:30:17 μμ
    Author     : Kostas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="styles.css">
        <title>Welcome</title>
    </head>
    <body>
        <h3 class="welcome">${message}</h3>
        <h3 class="failDel">${failDel}</h3>
        <div class="btns">
            <button class="del-acc" onclick="openForm()">Delete account</button>
            
            <a class="logout-btn" href="index.jsp" >Logout</a>
        </div>
        
        <form class="popup-form"  id="myForm" action="loginRegister" method="POST" >
            <div class="delete-box">
                <h1>Delete account</h1>
                <table class="delete-table">
                    <tr><td><input class="table-cell" type="text" name="username" placeholder="Username"</td></tr>
                    <tr><td><input class="table-cell" type="password" name="password1" placeholder="Password"</td></tr>
                    <tr><td><input class="table-cell confirm" type="submit" name="submit" value="Confirm"</td></tr>
                    <tr><td><input class="table-cell cancel" type="button" name="cancel" value="Cancel" onclick="closeForm()"</td></tr>
                </table>
            </div> 
        </form>
        
        <script>
            function openForm() {
              document.getElementById("myForm").style.display = "block";
            }

            function closeForm() {
              document.getElementById("myForm").style.display = "none";
            }           
        </script>
    </body>
</html>
