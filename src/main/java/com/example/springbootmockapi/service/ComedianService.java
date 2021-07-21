package com.example.springbootmockapi.service;

import com.example.springbootmockapi.model.comedian.Comedian;

import java.util.Collection;

/***
 * To regulate ComedianService
 * @author Bimsara Gunarathna
 * @since 7/19/2021
 */
public interface ComedianService {
    Comedian getAComedian(String id);
    Comedian createComedian(Comedian comedian);
    Comedian updateComedian(String id, Comedian comedian);
    boolean deleteComedian(String id);
    Collection<Comedian> getComedians();
}
