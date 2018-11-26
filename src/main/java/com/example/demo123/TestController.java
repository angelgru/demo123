package com.example.demo123;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {


    List<Person> persons = new ArrayList<>();

    @GetMapping("/")
    public List<Person> sample() {
        return persons;
    }

//    @RequestBody go transformira JSOn vo Java Object preku Jackson Mapper
//    Primer preku postman POST request http://localhost:8080/

//  {
//	    "id": "1",
//	    "firstName": "John",
//	    "lastName": "Mon"
//  }
    @PostMapping("/")
    public Person add(@RequestBody Person person) {
        persons.add(person);
        return person;
    }

//    Ako ispratish GET request do localhost:8080/1
//    kje se mapira 1 vo id

    @GetMapping("/{id}")
    public Person getOne(@PathVariable("id") String id) {
        Person person = null;

//        Prebaruvash vo listata dali kje go najdesh objektot so toa id
        for (Person p: persons) {
            if(p.getId().equals(id))
                person = p;
        }

        return person;
    }
}
