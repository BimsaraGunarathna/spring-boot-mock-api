package com.example.springbootmockapi.service;

import com.example.springbootmockapi.dto.comedian.ComedianDTO;

import java.util.Collection;

/***
 * To regulate ComedianService
 * @author Bimsara Gunarathna
 * @since 7/19/2021
 */
public interface ComedianService {
    ComedianDTO getAComedian(String id);
    ComedianDTO createComedian(ComedianDTO comedianDTO);
    ComedianDTO updateComedian(String id, ComedianDTO comedianDTO);
    boolean deleteComedian(String id);
    Collection<ComedianDTO> getComedians();
}
