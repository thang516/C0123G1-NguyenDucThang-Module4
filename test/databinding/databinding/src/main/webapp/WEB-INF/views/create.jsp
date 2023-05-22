<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form:form action="/create-user" modelAttribute="user" method="post">
    <p>user Name</p>
    <form: input type="text" path="username" />
    <p>password</p>
    <form: input type="text" path="password" />
    <p>Age</p>
    <form: input type="text" path="age" />
</form:form>
<button type="submit">Create</button>
</body>
</html>