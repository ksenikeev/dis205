<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div class="site">
    <div class="header">
<!--
        <img src="icon.jpg" alt="Иконка">
-->
    </div>

    <div class="main_section">
        <h2 color="red">${error!}</h2>
        <div class="main_section_login">
            <form action="/client/registercheck" method="post" >

                <p class="inf_text">
                    Логин:
                </p>
                <input type="text" name="name" placeholder="введите имя пользователя">

                <p class="inf_text">
                    Пароль:
                </p>
                <input type="text" name="password">

                <p class="inf_text">
                    Почта:
                </p>
                <input type="text" name="email" placeholder="введите почту">

                <div class="btn_into">
                    <input type="submit" value="зарегистрироваться" class="btn_into_input">
                </div>
            </form>
        </div>


    </div>
</div>
</body>
</html>