package ru.afanasiev.react2redis.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import reactor.core.publisher.Flux;
import ru.afanasiev.react2redis.models.Person;
import ru.afanasiev.react2redis.repositories.PeopleRepository;
import ru.afanasiev.react2redis.security.PersonDetails;
import ru.afanasiev.react2redis.services.AdminService;



@Controller
public class PersonController {
    private final AdminService adminService;
    private final PeopleRepository peopleRepository;

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
        System.out.println(personDetails.getPerson());

        return "hello";
    }
 /*   @GetMapping("/showUserInfoReact")
    public Flux<Person> showUserInfoReact(String s) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        System.out.println(personDetails.getPerson());

        return peopleRepository.findById(s);
    }*/


    @GetMapping("/admin")
    public String adminPage() {
        adminService.doAdminStuff();
        return "admin";
    }

}
