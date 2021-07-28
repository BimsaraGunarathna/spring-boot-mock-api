package com.example.springbootmockapi.mapper.impl;

import com.example.springbootmockapi.dto.ComedianDTO;
import com.example.springbootmockapi.dto.SpecialDTO;
import com.example.springbootmockapi.entity.comedian.Comedian;
import com.example.springbootmockapi.entity.special.Special;
import com.example.springbootmockapi.mapper.MapStructMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/***
 * Mappers for Comedian and Special
 * @author Bimsara Gunarathna
 * @since 7/27/2021
 */
@Component
public class MapStructMapperImpl implements MapStructMapper {
    @Override
    public Comedian comedianDTOToComedian(ComedianDTO comedianDTO) {

        if (comedianDTO == null) {
            return null;
        }

        Comedian comedian = new Comedian();

        comedian.setName( comedianDTO.getName());
        comedian.setRole((comedianDTO.getRole()));
        //comedian.setSpecials(comedianDTO.getSpecials());
        System.out.println("SPECIAL:" + comedianDTO.getSpecials());
        return comedian;
    }

    @Override
    public Collection<ComedianDTO> comediansToComedianDTOs(Collection<Comedian> comedians) {
        if( comedians == null) {
            return null;
        }

        Collection<ComedianDTO> comedianDTOCollection = new HashSet<>();
        for(Comedian comedian : comedians ) {
            comedianDTOCollection.add(new ComedianDTO(
                    comedian.getName(),
                    comedian.getRole()
                    //comedian.getSpecials()
            ));
        }
        return comedianDTOCollection;

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
