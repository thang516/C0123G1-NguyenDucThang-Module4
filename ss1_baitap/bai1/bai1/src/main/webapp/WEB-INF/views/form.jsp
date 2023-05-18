<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 5/18/2023
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center; padding: 10px ">
    <H1>Calculator</H1>
</div>
<div style="justify-content: center;display: flex" >
    <form  action="/" method="post" style="width: 30%">
        <div style="width: 350px;text-align: center">
            <label style="padding: 10px ">Exchange Rate</label>
            <input class="form-control" type="number" name="exchangeRate"  placeholder="Exchange Rate">
        </div>
       <div style="width: 350px;text-align: center">
           <label style="padding: 10px ">Dollar Amount</label>
           <input class="form-control" type="number" name="dollarAmount" placeholder="Dollar Amount"> <br>
       </div>
            <div style="text-align: center">
        <button type="submit"  >Calculate</button>
            </div>
        <h1 style="color: green;text-align: center ;padding-top: 20px">Result: ${result}</h1>
    </form>

</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>

</html>
