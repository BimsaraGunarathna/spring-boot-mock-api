package com.example.springbootmockapi.mapper;

import com.example.springbootmockapi.dto.ComedianDTO;
import com.example.springbootmockapi.dto.SpecialDTO;
import com.example.springbootmockapi.entity.comedian.Comedian;
import com.example.springbootmockapi.entity.special.Special;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

/***
 * Mappers template for Comedian and Special
 * @author Bimsara Gunarathna
 * @since 7/27/2021
 */
@Mapper(componentModel = "spring")
public interface MapStructMapper {
    Comedian comedianDTOToComedian(ComedianDTO comedianDTO);
    Collection<ComedianDTO> comediansToComedianDTOs(Collection<Comedian> comedians);
    ComedianDTO comedianToComedianDTO(Comedian comedian);

    SpecialDTO specialToSpecialDTO(Special special, Comedian specialComedian);
    Special specialDTOToSpecial(SpecialDTO specialDTO);
    Collection<SpecialDTO> specialsToSpecialDTOs(Collection<Special> specials);

}
