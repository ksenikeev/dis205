<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Главная страница</title>
</head>
<body>

    <h2>Информация о людях:</h2>

    <form action="/person/find" method="post">
        <div>
            name: <input type="text" name="name"/>
        </div>
        <div>
            passportnum: <input type="text" name="passportnum"/>
        </div>
        <div>
            <input type="submit" value="Найти">
        </div>
    </form>

    <table>
        <#list lst as person>
        <tr>
            <td>${person.name}</td>
            <td>${person.passport.paspnum}</td>
        </tr>
        </#list>
    </table>
</body>
</html>