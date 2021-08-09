package com.example.springbootmockapi.service;

import com.example.springbootmockapi.dto.comedian.ComedianDTO;
import com.example.springbootmockapi.dto.comedian.CreateComedianDTO;
import com.example.springbootmockapi.entity.comedian.Comedian;

import java.util.Collection;

/***
 * To regulate ComedianService
 * @author Bimsara Gunarathna
 * @since 7/19/2021
 */
public interface ComedianService {
    ComedianDTO getAComedian(String id);
    ComedianDTO createComedian(CreateComedianDTO comedianDTO);
    ComedianDTO updateComedian(String id, CreateComedianDTO comedianDTO);
    boolean deleteComedian(String id);
    Collection<ComedianDTO> getComedians();
}
