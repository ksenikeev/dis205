package ru.itis.dis205.lab2_8.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.dis205.lab2_8.model.Address;
import ru.itis.dis205.lab2_8.service.AddressService;

import java.util.List;

@Controller
public class AddressController {

    @Autowired
    private AddressService addressService;

    // принимаем запросы любым методом
    @RequestMapping("/")
    public String indexPage() {
        return "index";
    }

    @PostMapping("/address")
    public String addressPage(
            @RequestParam("name") String name, // параметр запроса
            @RequestParam("page") Integer page, // параметр запроса
            Model model // Объект для передачи данных в шаблон
    ) {

        List<Address> lst = addressService.findAddressByName(name, page);
        model.addAttribute("lst", lst);

        return "address";
    }

}
