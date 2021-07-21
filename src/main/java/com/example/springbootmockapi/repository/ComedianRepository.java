package com.example.springbootmockapi.repository;

import com.example.springbootmockapi.model.comedian.Comedian;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 * To store comedians to JPA
 * @author Bimsara Gunarathna
 * @since 7/19/2021
 */
public interface ComedianRepository extends JpaRepository<Comedian, Long> {
}
