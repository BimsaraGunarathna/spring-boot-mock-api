package com.example.springbootmockapi.mapper;

import com.example.springbootmockapi.dto.ComedianDTO;
import com.example.springbootmockapi.dto.SpecialDTO;
import com.example.springbootmockapi.entity.comedian.Comedian;
import com.example.springbootmockapi.entity.special.Special;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    Comedian comedianDTOToComedian(ComedianDTO comedianDTO);
    Collection<ComedianDTO> comediansToComedianDTOs(Collection<Comedian> comedians);

    Special specialDTOToSpecial(SpecialDTO specialDTO);
    Collection<Special> specialsToSpecialDTOs(Collection<Special> specials);
}
