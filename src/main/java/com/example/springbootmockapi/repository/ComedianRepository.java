package com.example.springbootmockapi.repository;

import com.example.springbootmockapi.entity.comedian.Comedian;
import org.springframework.data.mongodb.repository.MongoRepository;

/***
 * To store comedians to JPA
 * @author Bimsara Gunarathna
 * @since 7/19/2021
 */
public interface ComedianRepository extends MongoRepository<Comedian, String> {
}
