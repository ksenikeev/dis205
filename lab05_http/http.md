# Протокол HTTP 1.1
## спецификация RFC 2068

клиент - сервер

 С -> чепочка запросов -> S
 C <- цепочку ответов <-  S

HTTP - транспорт TCP/IP

Пакет (запрос, ответ):

ЗАГОЛОВОК (обязательно)
\r\n
ТЕЛО (опционально)

Заголовок - набор строк, заканчивающихся \r\n
\r\n
Тело - произвольный набор байт (интерпретация и длина описана в заголовке)

http://pb.adriver.ru/cgi-bin/bid.cgi

### Запрос (Request)
POST /cgi-bin/bid.cgi HTTP/1.1 \r\n - обязательный формат 1-й строки
Host: pb.adriver.ru \r\n
Content-Length: 494 \r\n
Content-Type: text/plain \r\n
\r\n
{"cur":["RUB"],"site":{"name":"https://habr.com","domain":"habr.com","id":"91:habr_728x90_Leaderboard-ru","page":"https://habr.com/ru/articles/431566/"},"id":"0.10977869789899564","user":{"buyerid":0},"device":{"ua":"Mozilla/5.0 (X11; Linux x86_64; Chromium GOST) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36","ip":"1"},"imp":[{"id":"91:habr_728x90_Leaderboard-ru","bidfloor":0,"bidfloorcur":"RUB","secure":1,"banner":{"w":0,"h":0,"format":[{"w":728,"h":90}]}}],"at":1}




### 1-я строка запроса
МЕТОД: (POST, GET, DELETE, PUT, HEAD)
 - GET: запрос ресурса (тело не содержит)
 - POST: отправляем параметры на ресурс (параметры передаем через тело запроса)

Ресурс /resource (http://cite.com/resource)

Версия протокола: HTTP/1.1

Параметры заголовка:
Ключ=Значение

### Ответ (Response)
HTTP/1.1 200 OK \r\n
Content-Length: 620 \r\n
Content-Type: application/json \r\n
Date: Fri, 29 Sep 2023 06:00:24 GMT \r\n
\r\n
{
"id": "0.10977869789899564",
"bidid": "DLztYeoFbQyZvz0zAtEWPBXCnOia-kdQ5PjKvdYclivfcuFq3W1YYzqpdcGUbq6_KZke4egvZC3C94FiftLh2aC8q12vhEmOvBFhBWiA",
"seatbid": [{
"bid" : [{
"id": "1",
"impid" : "91:habr_728x90_Leaderboard-ru",
"price": 14.11,
"h": 90,
"w": 728,
"adid" : "8860949",
"adomain" : ["citilink.ru"],
"nurl": "https://ad.adriver.ru/cgi-bin/erle.cgi?expid=DLztYeoFbQyZvz0zAtEWPBXCnOia-kdQ5PjKvdYclivfcuFq3W1YYzqpdcGUbq6_KZke4egvZC3C94FiftLh2aC8q12vhEmOvBFhBWiA&bid=8860949&advid=&wprc=14.11&tuid=-1&custom=207=91:habr_728x90_Leaderboard-ru",
"cid" : "754558",
"ext" : ""
}]
}],
"cur": "RUB"
}







## Коды ответов

- 200 ОК  (обобщенный положительный ответ)
- 201 Created (запрос успешный, данные созданы; используют для PUT или POST)
- 302 Moved Temporarily (страница перемещена, куда - смотрим заголовок Location)
- 400 Bad Request (неверно сформированный запрос)
- 401 Unauthorized (требуется выполнить аутентификацию)
- 404 Not Found (запрашиваемого ресурса нет)
- 405 Forbidden (для указанного ресурса метод не поддерживается)
- 500 Internal Server Error (ошибка на стороне сервера)




HTTP/1.1 302 Moved Temporarily
Server: nginx
Date: Sat, 08 Mar 2014 22:29:53 GMT
Content-Type: text/html
Content-Length: 154
Connection: keep-alive
Keep-Alive: timeout=25
Location: http://habrahabr.ru/users/alizar/

<html>
<head><title>302 Found</title></head>
<body bgcolor="white">
<center><h1>302 Found</h1></center>
<hr><center>nginx</center>
</body>
</html>




## Заголовки

- General Headers
- Request Headers
- Response Headers

- Accept (клиент ожидает ответ в определенном формате, Accept: text/plain)
- Accept-Charset (список поддерживаемых кодировок клиента, Accept-Charset: utf-8)
- Authorization (данные для авторизации на сервере, Authorization: Basic 9j787ewjkh,m232413==)
- Connection (сведения о состоянии соединения, Connection: close)
- Content-Encoding (сведения о кодировке, передаваемых данных, Content-Encoding: utf-8)
- Content-Length (Content-Length: 154)
- Content-Type (Content-Type: text/html;charset=utf-8) 
- Date (Date: Tue, 01 Nov 2022 08:11:11 GMT)
- Host (Доменное имя и порт хоста запрашиваемого ресурса, Host: itislabs.ru)
- Location (Новое расположение ресурса: Location: http://itislabs.ru/newaddress)
- Server (Server: NgInx)
- User-Agent (Mozilla/5.0 (X11; Linux i686; rv:2.0.1) Gecko/20100101 Firefox/4.0.1)
- Allow (Allow: GET, HEAD, OPTIONS)
