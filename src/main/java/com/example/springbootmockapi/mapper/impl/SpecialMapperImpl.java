package com.example.springbootmockapi.mapper.impl;

import com.example.springbootmockapi.dto.SpecialDTO;
import com.example.springbootmockapi.entity.special.Special;
import com.example.springbootmockapi.mapper.SpecialMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;

@Component
public class SpecialMapperImpl implements SpecialMapper {

    /**
     * to map special to a specialDTO
     * @param special
     * @return specialDTO
     */
    @Override
    public SpecialDTO specialToSpecialDTO(Special special) {
        if(special == null) {
            return null;
        }

        SpecialDTO specialDTO = new SpecialDTO();

        specialDTO.setName(special.getName());
        specialDTO.setDescription(specialDTO.getDescription());
        specialDTO.setComedianId(specialDTO.getComedianId());

        return specialDTO;

    }

    /**
     * to map specialDTO to special
     * @param specialDTO
     * @return special
     */
    @Override
    public Special specialDTOToSpecial(SpecialDTO specialDTO) {
        if(specialDTO == null) {
            return null;
        }

        Special special = new Special();

        special.setName(specialDTO.getName());
        special.setDescription(specialDTO.getDescription());

        return special;
    }

    /**
     * to map multiple specials to specialDTOs
     * @param specials
     * @return specialDTOs
     */
    @Override
    public Collection<SpecialDTO> specialsToSpecialDTOs(Collection<Special> specials) {
        if(specials == null) {
            return null;
        }

        Collection<SpecialDTO> specialDTOs = new HashSet<>();

        for(Special special : specials ) {
            specialDTOs.add(
                    new SpecialDTO(
                            special.getName(),
                            special.getDescription(),
                            special.getComedianId()
                    ));
        }
        return specialDTOs;
    }
}
