package com.example.good;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;




public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findBySurname(String surname);
}
