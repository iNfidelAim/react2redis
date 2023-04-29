package ru.afanasiev.react2redis.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.afanasiev.react2redis.models.Person;
import ru.afanasiev.react2redis.repositories.PeopleRepository;
import ru.afanasiev.react2redis.security.PersonDetails;
import ru.afanasiev.react2redis.services.AdminService;
import ru.afanasiev.react2redis.services.PersonService;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PersonController {
    private final AdminService adminService;
    private final PeopleRepository peopleRepository;

    PersonService personService;


    @Autowired
    public PersonController(AdminService adminService, PeopleRepository peopleRepository) {
        this.adminService = adminService;
        this.peopleRepository = peopleRepository;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }


    @GetMapping("/showUserInfo")
    public String showUserInfo() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        Person currenPerson = (Person) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(personDetails.getPerson());

        return "hello";
    }
    @GetMapping("/people")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Person> getAllTutorials(@RequestParam(required = false) String title) {
        if (title == null)
            return personService.findAll();
        else
            return personService.findById(title);
    }




    @GetMapping("/people/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Person> getTutorialById(@PathVariable("id") int id) {
        return personService.findById(id);
    }


    @GetMapping("/admin")
    public String adminPage() {
        adminService.doAdminStuff();
        return "admin";
    }

}
