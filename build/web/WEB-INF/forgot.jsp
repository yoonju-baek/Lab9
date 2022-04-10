<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body class="container">
        <h1>Forgot Password</h1>
        
        <c:if test="${message != null}">
            <div class="alert alert-danger" role="alert">
                <c:out value="${message}" />
            </div>
        </c:if>
                    
        <c:if test="${success != null}">
            <div class="alert alert-success" role="alert">
                <c:out value="${success}" />
            </div>
        </c:if>
        
        <p>Please enter your email address to retrieve your password.</p>
        <form action="forgot" method="post">
            <label>Email Address: </label>
            <input type="email" id="email" name="email"><br>
            <input type="submit" value="Submit">
        </form>
        
        <a href="login">Go back to Login</a>
    </body>
</html>
