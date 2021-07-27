package com.example.springbootmockapi.service;

import com.example.springbootmockapi.dto.ComedianDTO;
import com.example.springbootmockapi.entity.comedian.Comedian;

import java.util.Collection;

/***
 * To regulate ComedianService
 * @author Bimsara Gunarathna
 * @since 7/19/2021
 */
public interface ComedianService {
    Comedian getAComedian(String id);
    Comedian createComedian(ComedianDTO comedianDTO);
    Comedian updateComedian(String id, ComedianDTO comedian);
    boolean deleteComedian(String id);
    Collection<ComedianDTO> getComedians();
}
