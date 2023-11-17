<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Lab 10</title>
    <meta charset="utf-8"/>
</head>
<body>
<h1>Регистрация пользователя</h1>


    <form method="post" action="/lab10/registration">
        <table>
            <tr>
                <td><label>Имя:</label></td>
                <td><input type="text" name="name" placeholder="ваше имя"></td>
            </tr>
            <tr>
                <td><label>Логин:</label></td>
                <td><input type="text" name="username" placeholder="логин"></td>
            </tr>
            <tr>
                <td><label>Телефон:</label></td>
                <td><input type="text" name="phone" placeholder="+71111111111"></td>
            </tr>
            <tr>
                <td><label>Пароль:</label></td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td><label>Повторите пароль:</label></td>
                <td><input type="password"></td>
            </tr>
        </table>
        <div><input type="submit" value="Регистрация"></div>
    </form>
</body>
</html>