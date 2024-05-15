package ru.itis.dis205.lab2_13.openidprovider.security;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class OAuthService {
    public Map<Long, Long> oAuthRequest = new HashMap<>();
}
