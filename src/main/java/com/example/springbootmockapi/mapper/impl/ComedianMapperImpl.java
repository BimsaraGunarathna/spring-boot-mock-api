package com.example.springbootmockapi.mapper.impl;

import com.example.springbootmockapi.dto.comedian.ComedianDTO;
import com.example.springbootmockapi.dto.comedian.CreateComedianDTO;
import com.example.springbootmockapi.dto.special.CreateSpecialDTO;
import com.example.springbootmockapi.entity.comedian.Comedian;
import com.example.springbootmockapi.entity.special.Special;
import com.example.springbootmockapi.mapper.ComedianMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;

@Component
public class ComedianMapperImpl implements ComedianMapper {
    /**
     * To map single comedianDTO to comedian
     * @param comedianDTO
     * @return comedian
     */
    @Override
    public Comedian comedianDTOToComedian(ComedianDTO comedianDTO) {

        if (comedianDTO == null) {
            return null;
        }

        Comedian comedian = new Comedian();

        comedian.setName( comedianDTO.getName());
        comedian.setRole((comedianDTO.getRole()));


        return comedian;
    }

    /**
     * To map multiple comedians to comedianDTOs
     * @param comedians
     * @return comedianDTOs
     */
    @Override
    public Collection<ComedianDTO> comediansToComedianDTOs(Collection<Comedian> comedians) {
        if( comedians == null) {
            return null;
        }

        Collection<ComedianDTO> comedianDTOs = new HashSet<>();
        for(Comedian comedian : comedians ) {
            comedianDTOs.add(new ComedianDTO(
                    comedian.getId(),
                    comedian.getName(),
                    comedian.getRole()

            ));
        }
        return comedianDTOs;

    }

    /**
     * to map single comedian to comedianDTO
     * @param comedian
     * @return comedianDTO
     */
    @Override
    public ComedianDTO comedianToComedianDTO(Comedian comedian) {
        if(comedian == null) {
            return null;
        }
        ComedianDTO comedianDTO = new ComedianDTO(
                comedian.getId(),
                comedian.getName(),
                comedian.getRole()

        );

        return comedianDTO;
    }

    /**
     * to map single createComedianDTO to comedianDTO
     * @param createComedianDTO
     * @return comedianDTO
     */
    @Override
    public ComedianDTO createComedianDTOToComedianDTO(CreateComedianDTO createComedianDTO) {
        if (createComedianDTO == null) {
            return null;
        }

        ComedianDTO comedianDTO = new ComedianDTO(
                createComedianDTO.getName(),
                createComedianDTO.getRole()
        );

        return comedianDTO;
    }
}
