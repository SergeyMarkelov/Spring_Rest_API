package com.example.good;

public class PersonNotFoundException extends RuntimeException{
    PersonNotFoundException(Long id) {
        super("Could not find person " + id);
    }
    PersonNotFoundException(String surname) {
        super("Could not find person " + surname);
    }

}
