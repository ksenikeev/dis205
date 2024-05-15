# Хранение контекста spring security

<https://docs.spring.io/spring-security/reference/servlet/authentication/persistence.html>

## Напомним базовые принципы аутентификации пользователей при общении посредством http

Клиент обращается к ресурсу:
```http
GET / HTTP/1.1
Host: example.com
Cookie: SESSION=91470ce0-3f3c-455b-b7ad-079b02290f7b
```
Если клиент не аутентифицированный, то вместо ответа он получает предложение перейти на страницу логина:
```http
HTTP/1.1 302 Found
Location: /login
```
Клиент отправляет свои учетные данные (будем считать, что верные):
```http
POST /usercheck HTTP/1.1
Host: example.com
Cookie: SESSION=91470ce0-3f3c-455b-b7ad-079b02290f7b

username=user&password=password
```
Клиенту возвращается какой-то контент или предложение перейти на страницу, например, в корень сайта,
вместе с идентификатором сессии:
```http
HTTP/1.1 302 Found
Location: /
Set-Cookie: SESSION=4c66e474-3f5a-43ed-8e48-cc1d8cb1d1c8; Path=/; HttpOnly; SameSite=Lax
```
Дальнейшее обращение к серверу клиент делает, указывая этот идентификатор:
```http
GET / HTTP/1.1
Host: example.com
Cookie: SESSION=4c66e474-3f5a-43ed-8e48-cc1d8cb1d1c8
```
Как сервер поймет кто к нему обратился? Например, так:
```http
Map<String, User> session = new HashMap<>;
// Клиент залогинился:
session.put("4c66e474-3f5a-43ed-8e48-cc1d8cb1d1c8", user);
// пришел запрос с SESSIONID=4c66e474-3f5a-43ed-8e48-cc1d8cb1d1c8
User user = session.get("4c66e474-3f5a-43ed-8e48-cc1d8cb1d1c8");
...
```
В реальности задач больше, например, надо следить за сроком жизни сессии.


## Место, где проводить проверку аутентификации, 
удобно расположить в фильтрах, обрабатывая все запросы в рамках одной логики.

За извлечение и сохранение данных аутентификации отвечает SecurityContextPersistenceFilter (отмеченный как Deprecated)

Хранением и загрузкой занимается DelegatingSecurityContextRepository, переадресуя эти операции классам
RequestAttributeSecurityContextRepository и HttpSessionSecurityContextRepository (одному из двух или обоим)

Используя эти классы можно загружать или сохранять контекст "вручную". 
Так можно решить задачу "авто-логина" после регистрации пользователя:
```

```
