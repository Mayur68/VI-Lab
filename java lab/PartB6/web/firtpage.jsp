<%-- 
    Document   : firtpage
    Created on : Apr 29, 2024, 1:43:28 PM
    Author     : mayur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>
            Registered User
        </title>
    </head>
    <body>
        <jsp:useBean id="stud" scope="session" class="com.student">
            <jsp:setProperty name="stud" property="*" />
        </jsp:useBean>
        <p> your Roll number is:
            <jsp:getProperty name="stud" property="rollNo" />.</p>
        <p> Your Name is :
            <jsp:getProperty name="stud" property="name" />.</p>
        <p> Your COURSE Name is :
            <jsp:getProperty name="stud" property="course" />.</p>
        <p> Your SEM is :
            <jsp:getProperty name="stud" property="sem" />.</p>
    </body>
</html>

