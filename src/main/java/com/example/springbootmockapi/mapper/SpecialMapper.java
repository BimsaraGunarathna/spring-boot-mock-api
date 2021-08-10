package com.example.springbootmockapi.mapper;

import com.example.springbootmockapi.dto.special.SpecialDTO;
import com.example.springbootmockapi.entity.special.Special;
import org.mapstruct.Mapper;

import java.util.Collection;

/***
 * Mappers template for Comedian and Special
 * @author Bimsara Gunarathna
 * @since /02/2021
 */
@Mapper
public interface SpecialMapper {
    SpecialDTO specialToSpecialDTO(Special special);
    Special specialDTOToSpecial(SpecialDTO specialDTO);
    Collection<SpecialDTO> specialsToSpecialDTOs(Collection<Special> specials);

}
