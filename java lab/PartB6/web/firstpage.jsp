<%-- 
    Document   : firstpage
    Created on : Jun 19, 2024, 8:02:00 PM
    Author     : mayur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <title>
            Register User
        </title>
    </head>
    
        <jsp:useBean id="stud" scope="session" class="com.student">
            <jsp:setProperty name="stud" property="*" />
        </jsp:useBean>
        <p> your roll number is:
            <jsp:getProperty name="stud" property="rollNo" />.</p>
        <p> Your Name is :
            <jsp:getProperty name="stud" property="name" />.</p>
        <p> Your COURSE Name is :
            <jsp:getProperty name="stud" property="course" />.</p>
        <p> Your semester is :
            <jsp:getProperty name="stud" property="sem" />.</p>
    

