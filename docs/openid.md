# Протокло OAuth 2.0

<https://datatracker.ietf.org/doc/html/rfc6749>
<https://docs.github.com/ru/apps/oauth-apps/building-oauth-apps/authorizing-oauth-apps>

+--------+                                           +---------------+
|        |--(A)------- Authorization Grant --------->|               |
|        |                                           |               |
|        |<-(B)----------- Access Token -------------|               |
|        |               & Refresh Token             |               |
|        |                                           |               |
|        |                            +----------+   |               |
|        |--(C)---- Access Token ---->|          |   |               |
|        |                            |          |   |               |
|        |<-(D)- Protected Resource --| Resource |   | Authorization |
| Client |                            |  Server  |   |     Server    |
|        |--(E)---- Access Token ---->|          |   |               |
|        |                            |          |   |               |
|        |<-(F)- Invalid Token Error -|          |   |               |
|        |                            +----------+   |               |
|        |                                           |               |
|        |--(G)----------- Refresh Token ----------->|               |
|        |                                           |               |
|        |<-(H)----------- Access Token -------------|               |
+--------+           & Optional Refresh Token        +---------------+

               Figure 2: Refreshing an Expired Access Token


1. Пользователь инициирует процесс аутентификации на базовом интернет-сервисе, выбирая способ аутентификации 
(далее рассматриваем вариант, когда пользователь выбрал аутентификацию через внешнего провайдера, укзав какого именно,
а базовый сервис на основе выбора работает с некоторым URL)
2. \[Опционально\] происходит обмен ключами по протоколу Диффи-Хеллмана.
3. Интернет-сервис перенаправляет браузер пользователя на сайт провайдера, используя режим `checkid_setup`. checkid_immediate
4. Провайдер проверяет авторизацию пользователя, и действительно ли он хочет аутентифицироваться на базовом сервисе.
5. Провайдер передает базовому сервису результат аутентификации.

---
1. Регистрируемся на внешне сервисе и получаем токен доступа как разработчики

eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyIiwiaWQiOjIsImNhbGxiYWNrdXJsIjoiaHR0cDovL2xvY2FsaG9zdDo4MDkwL29hdXRoY2FsbGJhY2sifQ.Yt0YB9cjXeAxQx9MxG97jP0KpoJ7Qcc5h145JcNcH0I

2. Перекидываем на страницу аутентификации внешнего сервиса
    
    http://localhost:8091/login?oauth=2

    теперь на этой страничке пользователь аутентифицируется

eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyIiwiaWQiOiIxIn0.1SUHcJJVuerdTKhIbLuXiOtLEsNBF75IznEO2dxOhvE