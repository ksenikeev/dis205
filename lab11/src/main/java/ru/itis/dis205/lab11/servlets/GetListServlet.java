package ru.itis.dis205.lab11.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.itis.dis205.lab11.model.Merch;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 */
@WebServlet("/getlist")
public class GetListServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<Merch> merchList = new ArrayList<>();
        merchList.add(new Merch("0001", "Холодильник", 10000.00f));
        merchList.add(new Merch("0002", "Стиральная машина", 20000.00f));
        merchList.add(new Merch("0003", "Гриль", 3000.00f));

        String json = "[" + merchList.get(0) + "," + merchList.get(1)
                + "," + merchList.get(2) + "]";

        response.setContentType("application/json;charset=UTF-8");

        OutputStream os = response.getOutputStream();
        os.write(json.getBytes("UTF-8"));
    }
}
