<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 5/18/2023
  Time: 1:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center">
    <h1>Dictionary</h1>
    <form action="/" method="post">

       <div >
           <label>Enter English Words</label>
           <input  type="text" name="englishWord">
       </div>
        <button style="margin-top: 15px;margin-left: 51px" >Translation</button>
    </form>
    <h2 style="color: green">Result search: ${result}</h2>
</div>
</body>
</html>
