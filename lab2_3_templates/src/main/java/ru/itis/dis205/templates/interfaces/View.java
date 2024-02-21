package ru.itis.dis205.templates.interfaces;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;

public interface View {
    String getContentType();
    // Здесь работает шаблонизатор
    void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response);

}
