<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Lab 08</title>
    <meta charset="utf-8"/>
    <link rel="shortcut icon"
          href="/lab08/favicon.ico">
</head>
<body>
<h1>Товары</h1>

<#list merchs as merch>
    <fieldset>
        <legend>${merch.name}</legend>
        <div>Артикул: ${merch.articul}</div>
        <div>Наименование: ${merch.name}</div>
        <div>Цена: ${merch.price}</div>
        <div>
        <form method="post" action="/lab10/selectmerch">
            <input type="hidden" name="merchid" value="${merch.id}">
            <input type="submit" value="Выбрать">
        </form>
        </div>
    </fieldset>
</#list>

</body>
</html>