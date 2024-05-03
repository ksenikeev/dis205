package ru.itis.dis205.lab2_12.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.dis205.lab2_12.web.dto.AuthenticationResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8090/login"))
                .headers("Content-Type", "application/json;charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString(
                        "{\"username\":\"admin\",\"password\":\"pass\"}"))
                .build();

        HttpResponse response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        String respBody = (String) response.body();

        System.out.println(respBody);

        ObjectMapper mapper = new ObjectMapper();

        AuthenticationResponse ar = mapper.readValue(respBody, AuthenticationResponse.class);

        if (ar.getAccessToken() != null) {
            System.out.println(ar.getAccessToken());

            request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8090/admin/vehicles"))
                    .headers("Authorization","Bearer " + ar.getAccessToken())
                    .GET()
                    .build();

            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());


        }



    }
}
