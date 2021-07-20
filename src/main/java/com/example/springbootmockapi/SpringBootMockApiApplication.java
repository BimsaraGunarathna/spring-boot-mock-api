package com.example.springbootmockapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


@SpringBootApplication
public class SpringBootMockApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootMockApiApplication.class, args);
    }

}

/*
@SpringBootApplication
public class SpringBootMockApiApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMockApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String sql = "SELECT * FROM specials";
        List<Special> specials = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Special.class));
        specials.forEach(System.out :: println);
    }
}
*/