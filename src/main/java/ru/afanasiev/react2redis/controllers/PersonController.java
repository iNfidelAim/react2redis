package ru.afanasiev.react2redis.controllers;



import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.afanasiev.react2redis.security.PersonDetails;

@RequestMapping("/login")
public class PersonController {

    @GetMapping("/login")
    public String sayHello() {
        return "hello";
    }


    @GetMapping("/showUserInfo")
    public String showUserInfo() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        System.out.println(personDetails.getPerson());

        return "Somebody return";
    }
}
