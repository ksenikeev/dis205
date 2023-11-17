# web приложение

1. Для каждой страницы готовим сервлет
2. Отображение страницы через сервлет-шаблонизатор (freemarker)
3. Аутентификация - через механизм сеансов
4. Контроль пользователя - через механизм фильтров



# JS

https://learn.javascript.ru/



# Freemarker

```html
<#if hiddenid??>

</#if>

<#list model["orgs"] as org>

</#list>

```


# HTML

https://htmlbook.ru/html/
```
		<table id="orgs" class="table table-striped">
			<thead>
				<th>ИНН</th><th>КПП</th><th>Наименование</th>
			</thead>
			<tbody>
			<#list model["orgs"] as org>
			<tr>
				<td><#if org.inn??><a href="/hcont/admin/organization?id=${org.id}"> ${org.inn} </a></#if></td>
				<td><#if org.kpp??>${org.kpp}</#if></td>
				<td><#if org.name??>${org.name}</#if></td>
			</tr>
			</#list>
			</tbody>
		</table>

```

```html
	<ul>
		<li><a href='${model["app_path"]}'>Главная</a></li>
		<li><a href='${model["app_path"]}/admin/organizations'>Организации</a></li>
    </ul>
```

```html
<head>
	<meta charset="utf-8"/>
	<link rel='stylesheet' href='${model["app_path"]}/resources/css/main.css'>
	<link rel='stylesheet' href='${model["app_path"]}/resources/css/menu.css'>
	<script src='${model["app_path"]}/resources/js/hcont.js'></script>

	<title>Континент-сервис</title>
</head>
```

```html
<img src="URL" alt="альтернативный текст">
```

# CSS (Cascading Style Sheets)

1. Определение стиля внутри элемента (inline CSS)
```html
<h1 style="color:blue;">A Blue Heading</h1>
```
2. Определение стиля только для страницы (internal CSS)
```html
<style>
body {background-color: powderblue;}
h1   {color: blue;}
p    {color: red;}
</style>
```
3.  Определение стиля во внешнем файле (external CSS)
```html
<head>
  <link rel="stylesheet" href="styles.css">
</head>
```
4. Именованный стиль (класс)
```html
.highlighted-text {
  background-color: yellow;
  font-size: 18px;
}

/* Только для элементов <p> с классом special-text */
    p.special-text {
    color: blue;
    }
```
