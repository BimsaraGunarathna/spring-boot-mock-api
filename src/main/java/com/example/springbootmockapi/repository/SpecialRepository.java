package com.example.springbootmockapi.repository;

import com.example.springbootmockapi.entity.special.Special;
import org.springframework.data.mongodb.repository.MongoRepository;

/***
 * To store comedians to JPA
 * @author Bimsara Gunarathna
 * @since 7/23/2021
 */
public interface SpecialRepository extends MongoRepository<Special, String> {
}
