package com.example.springbootmockapi.repository;

import com.example.springbootmockapi.model.special.Special;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 * To store comedians to JPA
 * @author Bimsara Gunarathna
 * @since 7/23/2021
 */
public interface SpecialRepository extends JpaRepository<Special, Long> {
}
