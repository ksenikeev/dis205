<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Lab 10</title>
    <meta charset="utf-8"/>

    <script src='/lab10/resources/js/validate_form.js'></script>


    <style type="text/stylesheet">
        input:required:invalid {
        	border:1px solid red;
        }
        input:valid {
        	border:1px solid green;
        }
    </style>
</head>
<body>
<h1>Регистрация пользователя</h1>

    <div id="error"></div>
    <form method="post" action="/lab10/registration" onsubmit="return validate()"> <!-- validate  -->
        <table>
            <tr>
                <td><label>Имя<span style="color:red">*</span>:</label></td>
                <td><input type="text" name="name" placeholder="ваше имя" required ></td>
            </tr>
            <tr>
                <td><label>Логин:</label></td>
                <td><input type="text" name="username" placeholder="логин"></td>
            </tr>
            <tr>
                <td><label>Телефон:</label></td>
                <td><input type="text" name="phone" placeholder="+71111111111" required pattern="(8|(\+7))[0-9]{10}" ></td>
            </tr>
            <tr>
                <td><label>Пароль:</label></td>
                <td><input id="pwd" type="password" name="password" oninput="validatePassword(this)"></td>
            </tr>
            <tr>
                <td><label>Повторите пароль:</label></td>
                <td><input id="pwd1" type="password"></td>
            </tr>
        </table>
        <div><input type="submit" value="Регистрация"></div>
    </form>

</body>
</html>