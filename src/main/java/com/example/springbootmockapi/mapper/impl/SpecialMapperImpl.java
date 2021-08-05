package com.example.springbootmockapi.mapper.impl;

import com.example.springbootmockapi.dto.SpecialDTO;
import com.example.springbootmockapi.entity.special.Special;
import com.example.springbootmockapi.mapper.SpecialMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;

@Component
public class SpecialMapperImpl implements SpecialMapper {

    @Override
    public SpecialDTO specialToSpecialDTO(Special special) {
        if(special == null) {
            return null;
        }

        SpecialDTO specialDTO = new SpecialDTO();

        specialDTO.setName(special.getName());
        specialDTO.setDescription(specialDTO.getDescription());
        ///specialDTO.setComedian(specialComedian);

        return specialDTO;

    }

    @Override
    public Special specialDTOToSpecial(SpecialDTO specialDTO) {
        if(specialDTO == null) {
            return null;
        }

        Special special = new Special();

        special.setName(specialDTO.getName());
        special.setDescription(specialDTO.getDescription());
        return special;
        //special.setComedian(specialDTO.getComedianId());
    }

    @Override
    public Collection<SpecialDTO> specialsToSpecialDTOs(Collection<Special> specials) {
        if(specials == null) {
            return null;
        }

        Collection<SpecialDTO> specialDTOCollection = new HashSet<>();

        for(Special special : specials ) {
            specialDTOCollection.add(
                    new SpecialDTO(
                            special.getName(),
                            special.getDescription()
                            //comedian.getSpecials()
                    ));
        }
        return specialDTOCollection;
    }
}
