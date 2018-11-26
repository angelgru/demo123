package com.example.demo123;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

//    Ova e dependency injection, namesto da kreirash instanca od PersonRepository Spring gi kreira i gi injecti-ira tuka so @Autowired

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/")
    public List<Person> sample() {
        return null;
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
        personRepository.save(person);
        return person;
    }

//    Ako ispratish GET request do localhost:8080/1
//    kje se mapira 1 vo id

    @GetMapping("/{id}")
    public Person getOne(@PathVariable("id") int id) {
        Person person = null;

        try {
            person = (Person) personRepository.findById(id).orElseThrow(() -> new Exception("Person not found"));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return person;
    }
}
