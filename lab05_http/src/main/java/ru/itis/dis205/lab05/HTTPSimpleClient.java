package ru.itis.dis205.lab05;

public class HTTPSimpleClient {

    public static void main(String[] args) {
/*
        HTTPClient client = new HTTPClient();
        client.send("itislabs.ru", 80);
*/
/*
        HTTPGetParamsClient client = new HTTPGetParamsClient();
        client.send("itislabs.ru", 80, "/page","param1=val ue1&param2=va&lue2");
*/
/*
        HTTPPostParamsClient client = new HTTPPostParamsClient();
        client.send("itislabs.ru", 80, "/page","param1=val ue1&param2=va&lue2");
*/
        HTTPJsonParamsClient client = new HTTPJsonParamsClient();
        // {"param1":"value1", "param2":"value2"}
        client.send("itislabs.ru", 80,
                "/page","{\"param1\":\"value1\", \"param2\":\"value2\"}");
    }

}
