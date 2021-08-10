package com.example.springbootmockapi.mapper;

import com.example.springbootmockapi.dto.comedian.ComedianDTO;
import com.example.springbootmockapi.dto.comedian.CreateComedianDTO;
import com.example.springbootmockapi.entity.comedian.Comedian;

import org.mapstruct.Mapper;

import java.util.Collection;

/***
 * Mappers template for Comedian and Special
 * @author Bimsara Gunarathna
 * @since 8/01/2021
 */
@Mapper
public interface ComedianMapper {
    Comedian comedianDTOToComedian(ComedianDTO comedianDTO);
    Collection<ComedianDTO> comediansToComedianDTOs(Collection<Comedian> comedians);
    ComedianDTO comedianToComedianDTO(Comedian comedian);

    ComedianDTO createComedianDTOToComedianDTO(CreateComedianDTO createComedianDTO);
}
