# Telegram Bot

https://core.telegram.org/bots

https://core.telegram.org/bots/api

https://core.telegram.org/bots/tutorial

## Создание учетной записи бота и получение токена авторизации:

1. Ищем  @BotFather и запускаем
2. Даём команду для создания бота /newbot
3. Задаём имя бота
4. Задаем имя пользователя бота (должно заканчиваться на bot)

```
Done! Congratulations on your new bot. You will find it at t.me/dis205_test_bot. You can now add a description, about section and profile picture for your bot, see /help for a list of commands. By the way, when you've finished creating your cool bot, ping our Bot Support if you want a better username for it. Just make sure the bot is fully operational before you do this.

Use this token to access the HTTP API:
6407029250:AAEa2Pq7d2ozBoNRq-30ViTjllUAjefNgFw
Keep your token secure and store it safely, it can be used by anyone to control your bot.

For a description of the Bot API, see this page: https://core.telegram.org/bots/api
```

Проверим https://api.telegram.org/bot6582275798:AAEYRR_x6KHiMAzGr6_dwsZODZl0aCmTrWk/getMe

{"ok":true,"result":{"id":6407029250,"is_bot":true,"first_name":"dis205_test","username":"dis205_test_bot","can_join_groups":true,"can_read_all_group_messages":false,"supports_inline_queries":false}}

## Разработка бота на Java 
https://core.telegram.org/bots/tutorial


1. Добавляем в maven проект зависимость:
```Java
        <dependency>
            <groupId>org.telegram</groupId>
            <artifactId>telegrambots</artifactId>
            <version>6.0.1</version>
        </dependency>

```
2. Для обработки сообщений от бота создаем класс, наследующий `TelegramLongPollingBot`
3. Реализуем абстрактные методы