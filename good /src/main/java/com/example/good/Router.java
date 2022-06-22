package com.example.good;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Router {

    private final PersonRepository repository;

    Router(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/persons")
    List<Person> all() {
        return repository.findAll();
    }

    @PostMapping("/persons")
    Person newEmployee(@RequestBody Person newPerson) {
        return repository.save(newPerson);
    }

    // jeden człowiek

    @GetMapping("/persons/{id}") // find by id
    Person one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    @GetMapping("/personsfinder/{surname}") //find by surname
    Person one(@PathVariable String surname) {

        return repository.findBySurname(surname)
                .orElseThrow(() -> new PersonNotFoundException(surname));
    }



    @PutMapping("/persons/{id}")
    Person replaceEmployee(@RequestBody Person newPerson, @PathVariable Long id) {

        return repository.findById(id)
                .map(person -> {
                    person.setName(newPerson.getName());
                    person.setSurname(newPerson.getSurname());
                    person.setAddress(newPerson.getAddress());


                    return repository.save(person);
                })
                .orElseGet(() -> {
                    newPerson.setId(id);
                    return repository.save(newPerson);
                });
    }

    @DeleteMapping("/persons/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.findById(id);
    }
}