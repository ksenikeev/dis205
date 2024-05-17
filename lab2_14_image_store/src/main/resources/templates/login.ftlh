<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <div>
        <img src="${app_path!}/static/img/spring-logo.svg" height="30" alt="spring">
    </div>

    <div>
        <h2 color="red">${error!}</h2>
        <div class="main_section_login">
            <form action="${app_path!}/usercheck" method="post" >
                <div>
                    Логин:
                    <input type="text" name="username" placeholder="введите имя пользователя">
                </div>
                <div>
                    Пароль:
                    <input type="password" name="password">
                </div>
                <div>
                    <input type="submit" value="Вход"/>
                </div>
            </form>
        </div>
    </div>
</body>
</html>