<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form:form action="/email/update" method="post" modelAttribute="email">
    <div >
        <label>Languages</label>
        <form:select path="languages"  cssStyle="height: 30px;width: 200px;margin-left: 26px;">
            <form:option value="English">English</form:option>
            <form:option value="Vietnamese">Vietnamese </form:option>
            <form:option value="Japanese">Japanese</form:option>
            <form:option value="Chinese">Chinese </form:option>
        </form:select>

    </div>
    <div style="  margin-top: 20px;">
        <label>Page Size </label>
        <span style="margin-left: 33px">Show</span>
        <form:select path="pageSize" cssStyle="margin-left: 10px;">
            <form:option value="5">5</form:option>
            <form:option value="10">10</form:option>
            <form:option value="15">15</form:option>
            <form:option value="20">20</form:option>
            <form:option value="25">25</form:option>
            <form:option value="50">50</form:option>
            <form:option value="100">100</form:option>
        </form:select>
        <label> emails her page</label>
    </div>
   <div style="margin-top: 20px;">
       <label>Spams filter </label>
       <form:radiobutton path="spamsFilter" cssStyle="  margin-left: 17px;"/>Enable spams filter
   </div>

        <div style="margin-top: 20px">
            <label>Signature</label>
            <form:textarea  type="text" name="signature" path="signature" cssStyle="    margin-left: 30px; width: 200px; height: 59px;"/>
        </div>


    <button style="margin: 33px" type="submit">Update</button>
    <button type="button">Cancel</button>

</form:form>
<h3 style="color: green">${mess}</h3>

</body>
</html>