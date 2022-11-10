package com.example.daohibernate.controller;

import com.example.daohibernate.entity.Person;
import com.example.daohibernate.service.PersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/persons")
public class PersonsController {

    private PersonsService personsService;

    @Autowired

    public PersonsController(PersonsService personsService) {
        this.personsService = personsService;
    }

    @RequestMapping("/by-city")
    public List<Person> findByCity(@RequestParam Map<String, String> city) {
        return personsService.getPersonsByCity(city.get("city"));
    }
}
