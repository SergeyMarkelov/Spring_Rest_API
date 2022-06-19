package com.example.good;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Person {
    private @Id @GeneratedValue Long id;
    private String name;
    private String surname;
    private String address;

    Person() {}

    Person(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getSurname() {
        return this.surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address=address;
    }
    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Person))
            return false;
        Person person = (Person) o;
        return Objects.equals(this.id, person.id) && Objects.equals(this.name, person.name)
                && Objects.equals(this.surname, person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.surname);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.surname + '\'' + '}';
    }
}
