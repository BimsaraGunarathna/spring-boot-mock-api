package com.example.springbootmockapi.service;

import com.example.springbootmockapi.model.comedian.Comedian;
import com.example.springbootmockapi.model.special.Special;
import com.example.springbootmockapi.repository.ComedianRepository;
import com.example.springbootmockapi.repository.SpecialRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Bimsara Gunarathna
 * @since 7/18/2021
 */
@Configuration
class LoadDatabase {

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
            log.info("Preloading " + comedianRepository.save(new Comedian("Dave Chappelle", "stand up")));
            log.info("Preloading " + comedianRepository.save(new Comedian("Bill Burr", "rant comedy")));
            log.info("Preloading " + comedianRepository.save(new Comedian("George Carlin", "stand up")));
            log.info("Preloading " + comedianRepository.save(new Comedian("Ricky Gervais", "insult")));
            log.info("Preloading " + comedianRepository.save(new Comedian("Louis C.K", "insult")));
            log.info("Preloading " + comedianRepository.save(new Comedian("Robin Williams", "wholesome")));
            log.info("Preloading " + comedianRepository.save(new Comedian("Jerry Seinfeld", "sitcom")));
            log.info("Preloading " + comedianRepository.save(new Comedian("Kevin Hart", "stand up")));

            //Specials
            log.info("Preloading " + specialRepository.save(new Special("The Age of Spin", "It’s difficult to miss Dave Chappelle.")));
            log.info("Preloading " + specialRepository.save(new Special("Bare", "Australian comedian Jim Jefferies isn’t new to stand-up, either in the United States or elsewhere, but his name was passed around frequently after the San Bernardino shooting.")));
            log.info("Preloading " + specialRepository.save(new Special("Tamborine", "Before Tamborine, we hadn’t heard from Chris Rock in a long time. Sure, the 53-year-old comedian was one of a handful of significant names.")));
            log.info("Preloading " + specialRepository.save(new Special("A Speck of Dust", "Sarah Silverman’s made a career out of shock-and-awe. She’s known for her explicit sense of humor.")));
            log.info("Preloading " + specialRepository.save(new Special("Lobby Baby", "The most noteworthy thing about Seth Meyer’s new Netflix special may be that there’s a “Skip Trump Jokes” button you can use any time you need an out, but most of the laughs in this aren’t political. ")));
            log.info("Preloading " + specialRepository.save(new Special("Talking for Clapping", "Patton Oswalt‘s special Talking for Clapping is a gem. Much like 2009’s My Weakness is Strong, the comic, actor and writer excels while doing his thing on stage.")));
        };
    }
}