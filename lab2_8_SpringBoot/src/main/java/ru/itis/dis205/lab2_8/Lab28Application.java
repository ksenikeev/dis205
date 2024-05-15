package ru.itis.dis205.lab2_8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.itis.dis205.lab2_8.model.Passport;
import ru.itis.dis205.lab2_8.model.Person;
import ru.itis.dis205.lab2_8.model.PersonView;
import ru.itis.dis205.lab2_8.repository.PersonRepository;
import ru.itis.dis205.lab2_8.repository.PersonViewRepository;
import ru.itis.dis205.lab2_8.service.PersonService;

import java.util.List;

@SpringBootApplication
public class Lab28Application {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Lab28Application.class, args);

		PersonViewRepository personViewRepository =
				context.getBean(PersonViewRepository.class);


/*
		Iterable<PersonView> lst = personViewRepository.findAll();

		lst.forEach(System.out::println);

		PersonView pw = new PersonView();
		pw.setId(11l);
		pw.setName("pw");

		personViewRepository.save(pw);
*/

		PersonRepository personRepository =
				context.getBean(PersonRepository.class);

		//personRepository.findAllToPersonDto().forEach(System.out::println);
		personViewRepository.findAllToPersonFunc(1L).forEach(System.out::println);
	}
}
