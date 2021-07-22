package com.example.springbootmockapi.service;

import com.example.springbootmockapi.model.comedian.Comedian;
import com.example.springbootmockapi.model.comedian.ComedianRequest;

import java.util.Collection;

/***
 * To regulate ComedianService
 * @author Bimsara Gunarathna
 * @since 7/19/2021
 */
public interface ComedianService {
    Comedian getAComedian(String id);
    Comedian createComedian(ComedianRequest comedian);
    Comedian updateComedian(String id, Comedian comedian);
    boolean deleteComedian(String id);
    Collection<Comedian> getComedians();
}
