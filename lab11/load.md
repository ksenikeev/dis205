# События загрузки страницы

https://learn.javascript.ru/onload-ondomcontentloaded

# Fetch - сетевой запрос на сервер со странички

https://learn.javascript.ru/fetch

# ASYNC

https://learn.javascript.ru/async-await

# WEB Socket

https://github.com/apache/tomcat/blob/9.0.x/webapps/examples/WEB-INF/classes/websocket/chat/ChatAnnotation.java

https://jakarta.ee/specifications/websocket/2.0/websocket-spec-2.0


### Client side
https://learn.javascript.ru/websockets
```
    let proto = window.location.protocol == 'http:' ? 'ws:' : 'wss:';
    console.log(proto + '//' + window.location.host );
    //webSocket = new WebSocket(proto + '//'  + window.location.host + '/msg/' + name);
    webSocket = new WebSocket('ws://localhost:8080/lab11/msg/' + name);

    webSocket.onmessage = function receiveMessage(response) {
        let data = response['data'];
        //let json = JSON.parse(data);
        console.log(data);
    };

    webSocket.onerror = function errorShow() {
        alert('Ошибка авторизации')
    }
```

onOpen - происходит соединение

onMessage - пришло сообщение

onClose - соединение закрыто

onError - произошла ошибка