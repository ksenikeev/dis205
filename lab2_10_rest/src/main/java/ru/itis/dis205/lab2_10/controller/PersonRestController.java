package ru.itis.dis205.lab2_10.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.dis205.lab2_10.model.dto.FieldsDto;
import ru.itis.dis205.lab2_10.model.dto.PersonDto;

@RestController
@RequestMapping("/person")
public class PersonRestController {

    @PostMapping("/rest/save")
    public PersonDto savePerson(PersonDto personDto) {

        System.out.println(personDto);
        personDto.setId(10l);
        personDto.setName(personDto.getName() + " - ");
        personDto.setPassport(personDto.getPassport() + " - ");
        return personDto;
    }

    @PostMapping("/fields/post")
    public FieldsDto savePerson(@RequestBody FieldsDto fieldsDto) {

        System.out.println(fieldsDto);
        return fieldsDto;
    }
}
