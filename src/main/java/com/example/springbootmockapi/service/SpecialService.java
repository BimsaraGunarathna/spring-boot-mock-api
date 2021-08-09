package com.example.springbootmockapi.service;

import com.example.springbootmockapi.dto.special.CreateSpecialDTO;
import com.example.springbootmockapi.dto.special.SpecialDTO;
import com.example.springbootmockapi.entity.special.Special;

import java.util.Collection;

/***
 * To regulate ComedianService
 * @author Bimsara Gunarathna
 * @since 7/23/2021
 */
public interface SpecialService {
    SpecialDTO getASpecial(String id);
    SpecialDTO createSpecial(CreateSpecialDTO specialDTO);
    SpecialDTO updateSpecial(String id, CreateSpecialDTO specialDTO);
    boolean deleteSpecial(String id);
    Collection<Special> getSpecials();
}
