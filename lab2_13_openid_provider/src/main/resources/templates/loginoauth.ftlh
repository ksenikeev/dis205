<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Регистрация клиента OAuth</title>

    <link rel='stylesheet' href='/static/css/game.css'>
    <script src='/static/js/game.js'></script>

    <style type="text/css">
        body {
            font-family: Academy, Sans, Arial;
            color: #808080;
        }
        .container {
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .center-block {
          flex-direction: column;
          width: 600px;
        }
        input {
            border: 1px solid #bdbdbd;
            background-color: #fff;
            color: #212529 ;
            font-size: 1rem ;
            width: 100%;
            padding: 0.375rem 0.75rem;
            margin: 0;
            height: calc(2.25rem + 2px);
            font-weight: 400;
            border-radius: 0.25rem;
        }
        .error {
            color: #ff0000;
        }
        button {
            color: #ffffff;
            height: calc(2.25rem + 2px);
            background-color: #1f883d;
            padding: 5px 16px;
            line-height: 20px;
            border: 1px solid;
            border-radius: 6px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="center-block">
        <h1>Вход в систему</h1>
        <div id="errormessage">${errormessage!}</div>

        <form method="post" action="/oauthusercheck">
            <label for="username">Логин</label>
            <input id="username" name="username"/>
            <label for="password">Пароль</label>
            <input id="password" name="password"/>
            <input type="hidden" name="developerid" value="${developerid!}"/>
            <button type="submit">Вход</button>
        </form>

    </div>
</div>



</body>
</html>