package com.example.springbootmockapi.mapper.impl;

import com.example.springbootmockapi.dto.special.CreateSpecialDTO;
import com.example.springbootmockapi.dto.special.SpecialDTO;
import com.example.springbootmockapi.entity.special.Special;
import com.example.springbootmockapi.mapper.SpecialMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

@Component
public class SpecialMapperImpl implements SpecialMapper {

    /**
     * to map special to a specialDTO
     * @param special - A Special object
     * @return specialDTO
     */
    @Override
    public SpecialDTO specialToSpecialDTO(Special special) {
        if(special == null) {
            return null;
        }

        SpecialDTO specialDTO = new SpecialDTO();

        specialDTO.setId(special.getId());
        specialDTO.setName(special.getName());
        specialDTO.setDescription(special.getDescription());
        specialDTO.setComedianId(special.getComedianId());

        return specialDTO;

    }

    /**
     * to map specialDTO to special
     * @param specialDTO - A SpecialDTO object
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
        special.setComedianId(specialDTO.getComedianId());

        return special;
    }

    /**
     * to map multiple specials to specialDTOs
     * @param specials - A Special Collection
     * @return specialDTOs
     */
    @Override
    public Collection<SpecialDTO> specialsToSpecialDTOs(Collection<Special> specials) {
        if(specials == null) {
            return Collections.emptyList();
        }

        Collection<SpecialDTO> specialDTOs = new HashSet<>();

        for(Special special : specials ) {
            specialDTOs.add(
                    new SpecialDTO(
                            special.getId(),
                            special.getName(),
                            special.getDescription(),
                            special.getComedianId()
                    ));
        }
        return specialDTOs;
    }

    /**
     * to map a createSpecialDTO to a specialDTO
     * @param createSpecialDTO - A CreateSpecialDTO
     * @return specialDTO
     */
    @Override
    public SpecialDTO createSpecialDTOToSpecialDTO(CreateSpecialDTO createSpecialDTO) {
        if (createSpecialDTO == null) {
            return null;
        }

        return new SpecialDTO(
                createSpecialDTO.getName(),
                createSpecialDTO.getDescription(),
                createSpecialDTO.getComedianId()
        );
    }
}
