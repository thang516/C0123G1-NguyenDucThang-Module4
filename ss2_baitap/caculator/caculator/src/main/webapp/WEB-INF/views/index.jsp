<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/" method="post">
    <input type="number" placeholder="Enter any Number" name="number1">
    <input type="number" placeholder="Enter any Number" name="number2">
    <div style="margin-top: 15px">
        <button type="submit" value="addition" name="calculator">Addition(+)</button>
        <button type="submit" value="subtraction" name="calculator">Subtraction(-)</button>
        <button type="submit" value="multiplication" name="calculator">Multiplication(x)</button>
        <button type="submit" value="division" name="calculator">Division(/)</button>
</div>

</form>
<h2 style="color: green">Result Division :${result}</h2>

</body>
</html>