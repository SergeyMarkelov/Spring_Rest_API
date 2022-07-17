package com.example.good;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    //adding persons to my DB

    @Bean
    CommandLineRunner initDatabase(PersonRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Person("Ricardo", "Milos", "ricardo.milos@lol.com")));
            log.info("Preloading " + repository.save(new Person("Sergey","Markelov", "sergey@lol.com")));
            log.info("Preloading " + repository.save(new Person("Angelina","Jolie", "angelina.jolie@lol.com")));
            log.info("Preloading " + repository.save(new Person("Adele","Laurie", "adele.laurie@lol.com")));
            log.info("Preloading " + repository.save(new Person("Jackie","Chan", "jackie.chan@lol.com")));






        };
    }
}