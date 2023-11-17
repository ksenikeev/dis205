<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Lab 10</title>
    <meta charset="utf-8"/>
</head>
<body>
<h1>Аутентификация</h1>

<h2 color="red">${message}</h2>

    <form method="post" action="/lab10/usercheck">
        <table>
            <tr>
                <td><label>Имя:</label></td>
                <td><input type="text" name="username" placeholder="введите имя пользователя"></td>
            </tr>
            <tr>
                <td><label>Пароль:</label></td>
                <td><input type="password" name="password"></td>
            </tr>
        </table>
        <div><input type="submit" value="Вход"></div>
    </form>

    <div>
        <a href="/lab10/regpage">Регистрация</a>
    </div>
</body>
</html>