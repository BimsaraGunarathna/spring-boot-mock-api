package com.example.springbootmockapi.mapper;

import com.example.springbootmockapi.dto.ComedianDTO;
import com.example.springbootmockapi.entity.comedian.Comedian;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

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
}
