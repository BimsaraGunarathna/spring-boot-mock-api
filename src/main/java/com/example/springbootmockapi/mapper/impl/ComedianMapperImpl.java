package com.example.springbootmockapi.mapper.impl;

import com.example.springbootmockapi.dto.ComedianDTO;
import com.example.springbootmockapi.entity.comedian.Comedian;
import com.example.springbootmockapi.mapper.ComedianMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;

@Component
public class ComedianMapperImpl implements ComedianMapper {
    @Override
    public Comedian comedianDTOToComedian(ComedianDTO comedianDTO) {

        if (comedianDTO == null) {
            return null;
        }

        Comedian comedian = new Comedian();

        comedian.setName( comedianDTO.getName());
        comedian.setRole((comedianDTO.getRole()));
        //comedian.setSpecials(comedianDTO.getSpecials());
        //comedian.setSpecials(comedianDTO.getSpecials());
        //System.out.println("SPECIAL:" + comedianDTO.getSpecials());
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
    public ComedianDTO comedianToComedianDTO(Comedian comedian) {
        if(comedian == null) {
            return null;
        }
        ComedianDTO comedianDTO = new ComedianDTO(
                comedian.getName(),
                comedian.getRole()
        );

        return comedianDTO;
    }
}
