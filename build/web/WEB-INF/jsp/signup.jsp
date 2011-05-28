<%-- 
    Document   : register
    Created on : Feb 13, 2011, 1:39:36 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Signup</title>
        <link type="text/css" href="../style.css" rel="stylesheet" />
    </head>
    <body>
        <div id="logo"></div><br />

        <div style="background: #fff; padding: 10px">
        <h1>Signup on MyCash</h1>
        <!--form:form action="signup/account" commandName="userentity" method="POST">-->
            <form:form action="signup/success" modelAttribute="userentity" method="POST">
            <form:errors path="*" />
            <table>
                <tr>
                    <td><label>Email:</label></td>
                    <td><form:input path="email" /></td>
                </tr>
                <tr>
                    <td><label>Password:</label></td>
                    <td><form:password path="pass" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Signup" name="usersignup" /></td>
                </tr>
            </table>
        </form:form>
        </div>
    </body>
</html>
