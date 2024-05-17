<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Главная страница</title>
    <style>
        .container-menu {
            display: flex;
            justify-content: flex-end;
        }
    </style>
</head>
<body>

    <div class="container-menu"><a href="${app_path!}/"><img src="${app_path!}/static/img/home.svg" height="30" alt="Главная"/></a> </div>
    <h1>Настройки</h1>
    <form method="post" enctype="multipart/form-data" action="${app_path!}/loadavatar">
        <div>
            <img src="${app_path!}${avatar}" height="150" alt="Аватарка">
        </div>
        <input type="file" name="avatar">
        <input type="submit" value="Загрузить">
    </form>
    <div>
        <label for="email">Почта:</label>
        <input id="email" name="email" type="text" value="${email!}"/>
    </div>




</body>
</html>