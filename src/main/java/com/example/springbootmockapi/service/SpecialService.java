package com.example.springbootmockapi.service;

import com.example.springbootmockapi.dto.SpecialDTO;
import com.example.springbootmockapi.entity.special.Special;

import java.util.Collection;

/***
 * To regulate ComedianService
 * @author Bimsara Gunarathna
 * @since 7/23/2021
 */
public interface SpecialService {
    Special getASpecial(String id);
    Special createSpecial(SpecialDTO specialDTO);
    Special updateSpecial(String id, SpecialDTO specialDTO);
    boolean deleteSpecial(String id);
    Collection<Special> getSpecials();
}
