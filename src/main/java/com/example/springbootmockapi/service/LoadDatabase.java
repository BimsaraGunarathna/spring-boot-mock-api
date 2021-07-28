package com.example.springbootmockapi.service;

import com.example.springbootmockapi.entity.comedian.Comedian;
import com.example.springbootmockapi.entity.special.Special;
import com.example.springbootmockapi.repository.ComedianRepository;
import com.example.springbootmockapi.repository.SpecialRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    /***
     *
     * @param comedianRepository
     * @param specialRepository
     * @return
     */
    @Bean
    CommandLineRunner initDatabase(ComedianRepository comedianRepository, SpecialRepository specialRepository) {
        return args -> {
            //Comedians
            Comedian c1 = new Comedian("Dave Chappelle", "stand up" );
            Comedian c2 = new Comedian("Bill Burr", "rant comedy" );

            log.info("Preloading " + comedianRepository.save(c1));
            log.info("Preloading " + comedianRepository.save(c2));

            //Specials
            log.info("Preloading " + specialRepository.save(new Special(
                    "The Age of Spin",
                    "It’s difficult to miss Dave Chappelle."

            )));
            log.info("Preloading " + specialRepository.save(new Special(
                    "Bare",
                    "Australian comedian Jim Jefferies isn’t new to stand-up, either in the United States or elsewhere, but his name was passed around frequently after the San Bernardino shooting."

            )));
            log.info("Preloading " + specialRepository.save(new Special(
                    "Tamborine",
                    "Before Tamborine, we hadn’t heard from Chris Rock in a long time. Sure, the 53-year-old comedian was one of a handful of significant names.",
                    c1
            )));
            log.info("Preloading " + specialRepository.save(new Special(
                    "A Speck of Dust",
                    "Sarah Silverman’s made a career out of shock-and-awe. She’s known for her explicit sense of humor.",
                    c2
                    )));

        };
    }
}
