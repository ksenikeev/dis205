<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div class="site">
    <div class="header">

        <img src="/static/img/spring-logo.svg" alt="Иконка">
    </div>

    <div class="main_section">
        <h2 color="red">${error!}</h2>
        <div class="main_section_login">
            <form action="/client/logincheck" method="post" >

                <p class="inf_text">
                    Логин:
                </p>
                <input type="text" name="username" placeholder="введите имя пользователя">

                <p class="inf_text">
                    Пароль:
                </p>
                <input type="password" name="password">

                <div class="btn_into">
                    <input type="submit" value="Вход" class="btn_into_input">
                </div>
            </form>
        </div>

        <div class="main_section2">
            <p class="inf_text">
                Впервые у нас?
            </p>
            <a href="/client/registration">Регистрация</a>
        </div>
    </div>
</div>
</body>
</html>