package com.example.springbootmockapi.service;
import com.example.springbootmockapi.dto.special.SpecialDTO;

import java.util.Collection;

/***
 * To regulate ComedianService
 * @author Bimsara Gunarathna
 * @since 7/23/2021
 */
public interface SpecialService {
    SpecialDTO getASpecial(String id);
    SpecialDTO createSpecial(SpecialDTO specialDTO);
    SpecialDTO updateSpecial(String id, SpecialDTO specialDTO);
    boolean deleteSpecial(String id);
    Collection<SpecialDTO> getSpecials();
}
