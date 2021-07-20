package com.example.springbootmockapi.repositories;

import com.example.springbootmockapi.models.Comedian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComedianRepository extends JpaRepository<Comedian, Long> {
    Comedian findByName(String name);
}
