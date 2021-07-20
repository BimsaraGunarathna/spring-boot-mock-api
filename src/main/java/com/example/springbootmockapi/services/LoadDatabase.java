package com.example.springbootmockapi.services;

import com.example.springbootmockapi.models.Comedian;
import com.example.springbootmockapi.repositories.ComedianRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ComedianRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Comedian("Dave Chappelle", "stand up")));
            log.info("Preloading " + repository.save(new Comedian("Bill Burr", "rant comedy")));
            log.info("Preloading " + repository.save(new Comedian("George Carlin", "stand up")));
            log.info("Preloading " + repository.save(new Comedian("Ricky Gervais", "insult")));
            log.info("Preloading " + repository.save(new Comedian("Louis C.K", "insult")));

        };
    }
}