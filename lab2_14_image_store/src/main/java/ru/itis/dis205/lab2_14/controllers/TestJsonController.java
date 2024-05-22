package ru.itis.dis205.lab2_14.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestJsonController {

    @GetMapping("/testjson")
    @ResponseBody
    public List<AutoMerch> getJSONAutoMarket() throws JsonProcessingException {

        List<AutoMerch> lst = new ArrayList<>();

/*
        AutoMerch autoMerch1 = new AutoMerch();
        autoMerch1.setPrice("1000 r");
        autoMerch1.setPastPrice("2000 r");

        AutoMerch autoMerch2 = new AutoMerch();
        autoMerch1.setPrice("3000 r");
        autoMerch1.setPastPrice("1000 r");

        lst.add(autoMerch1);
        lst.add(autoMerch2);
*/

        ObjectMapper mapper = new ObjectMapper();
        String data = "[{\"price\":\"3000 r\",\"pastPrice\":\"1000 r\"},{\"price\":null,\"pastPrice\":null}]";

        lst = (List<AutoMerch>) mapper.readValue(data, new TypeReference<List<AutoMerch>>(){});


        return lst;
    }
}
