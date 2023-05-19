<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<div>
    <h1>Sandwich Condiments</h1>
    <form action="/" method="post">
        <input type="checkbox" value="lettuce" name="lettuce">
        <label>Lettuce</label>
        <input type="checkbox" value="tomato" name="tomato">
        <label>Tomato</label>
        <input type="checkbox"  value="mustard" name="mustard">
        <label>Mustard</label>
        <input type="checkbox" value="sprouts" name="sprouts">
        <label>Sprouts</label>
        <input type="submit" value="Save">
    </form>

    <h3>${lettuce}  ${tomato}  ${mustard}  ${sprouts}</h3>
</div>
</body>
</html>