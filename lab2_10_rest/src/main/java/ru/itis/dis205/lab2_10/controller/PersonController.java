package ru.itis.dis205.lab2_10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.dis205.lab2_10.model.Passport;
import ru.itis.dis205.lab2_10.model.Person;
import ru.itis.dis205.lab2_10.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @RequestMapping("/new") // /person/new
    public String newPerson(Model model) {
        return "newperson";
    }

    @RequestMapping("/list") // /person/new
    public String listPersons(Model model) {
        Iterable<Person> lst = service.findAll();
        model.addAttribute("lst", lst);
        return "personlist";
    }

    @PostMapping("/find")
    public String findPerson(Model model,
                             @RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "passportnum", required = false) String passportnum) {

        Iterable<Person> lst = service.findPerson(name, passportnum);
        model.addAttribute("lst", lst);
        return "personlist";
    }

    @PostMapping("/save")
    public String savePerson(Model model,
             @RequestParam(value = "name") String name,
             @RequestParam(value = "passportnum", required = false) String passportnum) {

        Person person = new Person();
        person.setName(name);

        if (passportnum != null) {
            Passport passport = new Passport();
            passport.setPaspnum(passportnum);
            person.setPassport(passport);
        }

        person = service.save(person);

        model.addAttribute("person", person);

        return "personinfo";
    }




}
